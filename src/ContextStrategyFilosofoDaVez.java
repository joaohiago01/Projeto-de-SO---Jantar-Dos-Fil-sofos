
public class ContextStrategyFilosofoDaVez {

	private FilosofoDaVez filosofoDaVez;
	
	public void falaDoFilosofo(String nome, String restoDaFrase, MesaDosFilosofos mesaDosFilosofos) {
		switch (nome) {
		case "Platão":
			filosofoDaVez = new Platao();
			break;

		case "Aristóteles":
			filosofoDaVez = new Aristoteles();
			break;
			
		case "Sócrates":
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
