
public class Tales implements FilosofoDaVez {

	@Override
	public void atualizarLabel(String nome, String restoDaFrase, MesaDosFilosofos mesaDosFilosofos) {
		// TODO Auto-generated method stub
		mesaDosFilosofos.lblFilosofo_Tales.setText(nome + restoDaFrase);
		//System.out.println("O filósofo " + nome + restoDaFrase);
		mesaDosFilosofos.repaint();
	}
}
