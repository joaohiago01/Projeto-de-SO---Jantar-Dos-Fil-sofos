import java.util.Random;

import javax.swing.JOptionPane;

public class Garfos extends Thread{

	public final int garfoDireita;
	public final int garfoEsquerda;

	public Garfos (int garfoEsquerda, int garfoDireita) {
		this.garfoEsquerda = garfoEsquerda;
		this.garfoDireita = garfoDireita;
	}

	public void run() {
		// TODO Auto-generated method stub
		//super.run();

		while (true) {
			try {
				sorteioDireita();
				sorteioEsquerda();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	private void sorteioEsquerda() {
		// TODO Auto-generated method stub
		int garfoDireita;
		Random random = new Random();
		garfoDireita = random.nextInt(5);

		//JOptionPane.showMessageDialog(null, "O garfo da direita sorteado " + garfoDireita);
		System.out.println("O garfo da direita sorteado é o número " + garfoDireita);

	}

	private void sorteioDireita() {
		// TODO Auto-generated method stub
		int garfoEsquerda;
		Random random = new Random();
		garfoEsquerda = random.nextInt(5);

		//JOptionPane.showMessageDialog(null, "O garfo da esquerda sorteado " + garfoEsquerda);
		System.out.println("O garfo da esquerda sorteado é o número " + garfoEsquerda);

	}


}
