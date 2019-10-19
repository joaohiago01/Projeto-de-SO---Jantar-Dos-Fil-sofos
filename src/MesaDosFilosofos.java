import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class MesaDosFilosofos extends JFrame {

	public JLabel mesaDosFilosfos, lblFilosofo_Platao, lblFilosofo_Aristoteles, lblFilosofo_Socrates, lblFilosofo_Tales, lblFilosofo_Euclides,
	lblGarfo_1, lblGarfo_2, lblGarfo_3, lblGarfo_4, lblGarfo_5;
	public JButton btnComecarOJantar;
	
	public MesaDosFilosofos() {
		
		this.setSize(950, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Jantar Dos Filósofos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon mesaDosFilosofos = new ImageIcon("imagens/mesaDoJantar.gif");
		this.setIconImage(mesaDosFilosofos.getImage().getScaledInstance(1, 1, 0));
		getContentPane().setLayout(null);
		
		mesaDosFilosfos = new JLabel(mesaDosFilosofos);
		mesaDosFilosfos.setBounds(280, 250, 300, 280);
		getContentPane().add(mesaDosFilosfos);
		
		ImageIcon filosofo1 = new ImageIcon("imagens/icons8-espaguete-64.png");
		this.setIconImage(filosofo1.getImage().getScaledInstance(1, 1, 0));
		lblFilosofo_Tales = new JLabel("Tales");
		lblFilosofo_Tales.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilosofo_Tales.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Tales.setBounds(600, 500, 250, 100);
		getContentPane().add(lblFilosofo_Tales);
		
		lblFilosofo_Aristoteles = new JLabel("Aristóteles");
		lblFilosofo_Aristoteles.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilosofo_Aristoteles.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Aristoteles.setBounds(150, 500, 250, 100);
		getContentPane().add(lblFilosofo_Aristoteles);
		
		lblFilosofo_Platao = new JLabel("Platão");
		lblFilosofo_Platao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilosofo_Platao.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Platao.setBounds(30, 300, 250, 100);
		getContentPane().add(lblFilosofo_Platao);
		
		lblFilosofo_Socrates = new JLabel("Sócrates");
		lblFilosofo_Socrates.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilosofo_Socrates.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Socrates.setBounds(300, 150, 250, 100);
		getContentPane().add(lblFilosofo_Socrates);
		
		lblFilosofo_Euclides = new JLabel("Euclides");
		lblFilosofo_Euclides.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFilosofo_Euclides.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Euclides.setBounds(650, 300, 250, 100);
		getContentPane().add(lblFilosofo_Euclides);
				
		btnComecarOJantar = new JButton("Come\u00E7ar O Jantar Dos Fil\u00F3sofos");
		btnComecarOJantar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnComecarOJantar.setBounds(330, 30, 250, 30);
		getContentPane().add(btnComecarOJantar);
		OuvinteMesaDosFilosofos ouvinteMesaDosFilosofos = new OuvinteMesaDosFilosofos(this);
		btnComecarOJantar.addActionListener(ouvinteMesaDosFilosofos);
		
		this.setVisible(true);
	}
}
