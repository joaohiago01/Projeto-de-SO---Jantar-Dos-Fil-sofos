
public class ContextStrategyFilosofoDaVez {

	private FilosofoDaVez filosofoDaVez;
	
	public void falaDoFilosofo(String nome, String restoDaFrase, MesaDosFilosofos mesaDosFilosofos) {
		switch (nome) {
		case "Plat�o":
			filosofoDaVez = new Platao();
			break;

		case "Arist�teles":
			filosofoDaVez = new Aristoteles();
			break;
			
		case "S�crates":
			filosofoDaVez = new Socrates();
			break;
			
		case "Tales":
			filosofoDaVez = new Tales();
			break;
			
		case "Euclides":
			filosofoDaVez = new Euclides();
			break;
		}
		
		filosofoDaVez.atualizarLabel(nome, restoDaFrase, mesaDosFilosofos);
	}
}
