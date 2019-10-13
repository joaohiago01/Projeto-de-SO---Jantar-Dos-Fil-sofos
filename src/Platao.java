
public class Platao implements FilosofoDaVez {
	
	@Override
	public void atualizarLabel(String nome, String restoDaFrase, MesaDosFilosofos mesaDosFilosofos) {
		// TODO Auto-generated method stub
		mesaDosFilosofos.lblFilosofo_Platao.setText(nome + restoDaFrase);
		//System.out.println("O filósofo " + nome + restoDaFrase);
		mesaDosFilosofos.repaint();
	}
}
