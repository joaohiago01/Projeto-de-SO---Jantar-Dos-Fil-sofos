
public class Euclides implements FilosofoDaVez {

	@Override
	public void atualizarLabel(String nome, String restoDaFrase, MesaDosFilosofos mesaDosFilosofos) {
		// TODO Auto-generated method stub
		mesaDosFilosofos.lblFilosofo_Euclides.setText(nome + restoDaFrase);
		//System.out.println("O fil�sofo " + nome + restoDaFrase);
		mesaDosFilosofos.repaint();
	}
}
