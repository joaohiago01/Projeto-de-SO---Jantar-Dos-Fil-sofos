import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

public class OuvinteMesaDosFilosofos implements ActionListener {

	private MesaDosFilosofos mesaDosFilosofos;
	private ContextStrategyFilosofoDaVez filosofoDaVez = new ContextStrategyFilosofoDaVez();

	public static Semaphore mutex = new Semaphore(1);
	//semaforo para cada filosofo
	public static Semaphore[] semaforos = new Semaphore[5]; 
	public static Filosofo[] filosofos = new Filosofo[5];
	public static int[] estado = new int[5];

	public OuvinteMesaDosFilosofos(MesaDosFilosofos mesaDosFilosofos) {
		// TODO Auto-generated constructor stub
		this.mesaDosFilosofos = mesaDosFilosofos;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*Filosofo comecarJantarDosFilosofos = new Filosofo();
		comecarJantarDosFilosofos.test();*/
		String button = e.getActionCommand();
		switch (button) {
		case "Começar O Jantar Dos Filósofos":
			for (int i = 0; i < estado.length; i++) {
				estado[i] = 0;
			}

			// Inicializa todos filósofos
			filosofos[0] = new Filosofo("Sócrates", 0);
			filosofos[1] = new Filosofo("Platão", 1);
			filosofos[2] = new Filosofo("Aristóteles", 2);
			filosofos[3] = new Filosofo("Tales", 3);
			filosofos[4] = new Filosofo("Euclides", 4);

			//saber quais garfos pertence aos filosofos
			/*for (int i = 0; i < filosofos.length; i++) {            
				System.out.println("Garfo " + i + " - Filósofo " + filosofos[i].getName() + " - Garfo " + (i + 1) % 5);            
			}*/
			//System.out.println("");        
			for (int i = 0; i < semaforos.length; i++) {
				semaforos[i] = new Semaphore(0);
			}

			for (int i = 0; i < filosofos.length; i++) {
				filosofos[i].start();
			}

			break;

		case "Encerrar O Jantar Dos Filósofos":

			for (int i = 0; i < filosofos.length; i++) {
				try {
					synchronized (filosofos[i]) {
						filosofos[i].wait();//Não sei se tá certo, porque não tá só colocando as Threads em espera mas a minha janela toda fica parada, pra eu fechar tenho que toda vez encerrar a execução
					}

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			break;
		}

	}

	public class Filosofo extends Thread {

		public int id;

		public final int PENSANDO = 0;
		public final int COM_FOME = 1;
		public final int COMENDO = 2;

		public Filosofo(String nome, int id) {
			super(nome);
			this.id = id;
		}

		public void ComFome() {
			estado[this.id] = 1;
			filosofoDaVez.falaDoFilosofo(getName(), " está FAMINTO!", mesaDosFilosofos);
			//System.out.println("O Filósofo " + getName() + " está FAMINTO!");
		}

		public void Come() {
			estado[this.id] = 2;
			filosofoDaVez.falaDoFilosofo(getName()," está COMENDO!" , mesaDosFilosofos);
			//System.out.println("O Filósofo " + getName() + " está COMENDO!\n");
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException ex) {
				System.out.println("ERROR>" + ex.getMessage());
			}
		}

		public void Pensa() {
			estado[this.id] = 0;
			filosofoDaVez.falaDoFilosofo(getName(), " está PENSANDO!", mesaDosFilosofos);
			//System.out.println("O Filósofo " + getName() + " está PENSANDO!");
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException ex) {
				System.out.println("ERROR>" + ex.getMessage());
			}
		}

		public void LargarGarfo() throws InterruptedException {
			mutex.acquire();
			Pensa();
			/*Quando um filosofo largar os garfos, o vizinho da esquera e da direita
		        podem tentar pegar os garfos*/
			filosofos[VizinhoEsquerda()].TentarObterGarfos();
			filosofos[VizinhoDireita()].TentarObterGarfos();
			mutex.release();
		}

		public void PegarGarfo() throws InterruptedException {
			mutex.acquire();
			ComFome();
			//caso a condição for verdadeira, semaforo(1), permitindo
			//que o filosofo obtenha os garfos
			TentarObterGarfos();        
			mutex.release();
			//caso a condição não seja verdadeira, o filosofo vai ficar travado
			//no seu respectivo indice do semaforo, até chegar sua vez novamente
			//para tentar pegar os garfos
			semaforos[this.id].acquire();//semaforos[this.id] = new Semaphore(0)
		}

		public void TentarObterGarfos() {
			//se o filosofo estiver faminto e o vizinho esquerdo e direito não
			//estiver comendo, chama metodo come();
			try {
				if (estado[this.id] == 1) {
					if (estado[VizinhoDireita()] != 2) {
						filosofoDaVez.falaDoFilosofo(getName(), " pegou o garfo da DIREITA!", mesaDosFilosofos);
						Thread.sleep(2000);//Eu coloquei as Threads para dormir a cada ação do filósofo porque se não a troca do texto da label acontece muito rápido e não dá pra ver
						//System.out.println("O filósofo " + getName() + " pegou o garfo da DIREITA!");
						if (estado[VizinhoEsquerda()] != 2) {
							filosofoDaVez.falaDoFilosofo(getName(), " pegou o garfo da ESQUERDA!", mesaDosFilosofos);
							Thread.sleep(2000);
							//System.out.println("O filósofo " + getName() + " pegou o garfo da ESQUERDA!");
							Come();
							semaforos[this.id].release();//semaforos[this.id] = new Semaphore(1)
						} else {
							filosofoDaVez.falaDoFilosofo(getName(), " está com o garfo a sua direita OCUPADO!", mesaDosFilosofos);
							Thread.sleep(2000);
							filosofoDaVez.falaDoFilosofo(getName(), " não conseguiu COMER!", mesaDosFilosofos);
							Thread.sleep(2000);
							//System.out.println("O garfo a direita de " + getName() + " está OCUPADO!");
							//System.out.println(getName() + " não conseguiu COMER!\n");
						}
					} else {
						filosofoDaVez.falaDoFilosofo(getName(), " está com o garfo a sua esquerda OCUPADO!", mesaDosFilosofos);
						Thread.sleep(2000);
						filosofoDaVez.falaDoFilosofo(getName(), " não conseguiu COMER!", mesaDosFilosofos);
						Thread.sleep(2000);
						//System.out.println("O garfo a esquerda de " + getName() + " está OCUPADO!");
						//System.out.println(getName() + " não conseguiu COMER!\n");
					}
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}

		@Override
		public void run() {
			try {
				Pensa();
				//System.out.println("Estão pensando...");
				do {
					PegarGarfo();
					Thread.sleep(1000L);
					LargarGarfo();
				} while (true);
			} catch (InterruptedException ex) {
				System.out.println("ERROR>" + ex.getMessage());
				return;
			}
		}

		public int VizinhoDireita() {
			return (this.id + 1) % 5;
		}

		public int VizinhoEsquerda() {
			// filosofo 0 recebe vizinho a esquerda 4, porque se calcularmos
			//o resultado será -1.
			if (this.id == 0) {            
				return 4;
			} else {
				return (this.id - 1) % 5;
			}
		}
	}

	//Nessa classe filosofo que achei eu não tava conseguindo atualizar certo as label de cada filósofo, por isso procurei e usei a outra 
	/*public class Filosofo extends Thread {

		private String nome;
		private Garfos garfos;
		private int lugarNaMesa;

		public Filosofo () {}

		public Filosofo (String nome, Garfos garfos, int lugarNaMesa) {
			this.nome = nome;
			this.garfos = garfos;
			this.lugarNaMesa = lugarNaMesa;

			//JOptionPane.showMessageDialog(null, "O filósofo " + nome + " sentou á mesa.");
			//System.out.println("O filósofo " + nome + " sentou á mesa.");
			filosofoDaVez.falaDoFilosofo(nome, " sentou á mesa.", mesaDosFilosofos);
		}

		public void pensar () throws InterruptedException {
			filosofoDaVez.falaDoFilosofo(nome, " está pensando...", mesaDosFilosofos);
			//System.out.println("O filósofo " + nome + " está pensando...");
			//JOptionPane.showMessageDialog(null, "O filósofo " + nome + " está pensando...");
			Thread.sleep(1000);
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			while (true) {

				tentarPegarGarfo(5, 1);
				tentarPegarGarfo(1, 2);
				tentarPegarGarfo(2, 3);
				tentarPegarGarfo(3, 4);
				tentarPegarGarfo(4, 5);

			}
		}

		public void tentarPegarGarfo (int garfoDireita, int garfoEsquerda) {

			if (garfos.garfoDireita == garfoDireita) {

				filosofoDaVez.falaDoFilosofo(nome, " pegou o garfo da direita.", mesaDosFilosofos);
				mesaDosFilosofos.repaint();
				if (garfos.garfoEsquerda == garfoEsquerda) {

					filosofoDaVez.falaDoFilosofo(nome, " pegou o garfo da esquerda.", mesaDosFilosofos);
					mesaDosFilosofos.repaint();
					filosofoDaVez.falaDoFilosofo(nome, " está comendo.", mesaDosFilosofos);
					mesaDosFilosofos.repaint();
					filosofoDaVez.falaDoFilosofo(nome, " largou o garfo da direita.", mesaDosFilosofos);
					mesaDosFilosofos.repaint();
					filosofoDaVez.falaDoFilosofo(nome, " largou  garfo da esquerda", mesaDosFilosofos);
					mesaDosFilosofos.repaint();

				} else {
					filosofoDaVez.falaDoFilosofo(nome, " largou o garfo da direita, pois está sendo usado.", mesaDosFilosofos);
					mesaDosFilosofos.repaint();
				}
			} else {
				try {
					pensar();
				} catch (InterruptedException e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}

		}

		public void test() {

			Garfos garfo1 = new Garfos(1, 5);
			Garfos garfo2 = new Garfos(2, 1);
			Garfos garfo3 = new Garfos(3, 2);
			Garfos garfo4 = new Garfos(4, 3);
			Garfos garfo5 = new Garfos(5, 4);

			Filosofo filosofo1 = new Filosofo("Platão", garfo1, 1);
			Filosofo filosofo2 = new Filosofo("Aristóteles", garfo2, 2);
			Filosofo filosofo3 = new Filosofo("Sócrates", garfo3, 3);
			Filosofo filosofo4 = new Filosofo("Descartes", garfo4, 4);
			Filosofo filosofo5 = new Filosofo("Euclides", garfo5, 5);

			new Thread(filosofo1).start();
			new Thread(filosofo2).start();
			new Thread(filosofo3).start();
			new Thread(filosofo4).start();
			new Thread(filosofo5).start();
		}
	}*/

}
