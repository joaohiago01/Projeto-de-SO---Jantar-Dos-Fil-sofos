import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class MesaDosFilosofos extends JFrame {

	public JLabel mesaDosFilosfos, lblFilosofo_Platao, lblFilosofo_Aristoteles, lblFilosofo_Socrates, lblFilosofo_Tales, lblFilosofo_Euclides,
	lblGarfo_1, lblGarfo_2, lblGarfo_3, lblGarfo_4, lblGarfo_5;
	public JButton btnComecarOJantar;
	
	public MesaDosFilosofos() {
		
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Jantar Dos Filósofos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon mesaDosFilosofos = new ImageIcon("imagens/mesaDoJantar.gif");
		this.setIconImage(mesaDosFilosofos.getImage().getScaledInstance(1, 1, 0));
		getContentPane().setLayout(null);
		
		mesaDosFilosfos = new JLabel(mesaDosFilosofos);
		mesaDosFilosfos.setBounds(340, 250, 280, 280);
		getContentPane().add(mesaDosFilosfos);
		
		lblFilosofo_Tales = new JLabel("Tales");
		lblFilosofo_Tales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilosofo_Tales.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Tales.setBounds(500, 530, 350, 100);
		lblFilosofo_Tales.setIcon(new ImageIcon("imagens/tales.jpg"));
		lblFilosofo_Tales.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilosofo_Tales.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilosofo_Tales.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFilosofo_Tales);
		
		lblFilosofo_Aristoteles = new JLabel("Aristóteles");
		lblFilosofo_Aristoteles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilosofo_Aristoteles.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Aristoteles.setBounds(100, 530, 350, 100);
		lblFilosofo_Aristoteles.setIcon(new ImageIcon("imagens/aristoteles.jpg"));
		lblFilosofo_Aristoteles.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilosofo_Aristoteles.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilosofo_Aristoteles.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFilosofo_Aristoteles);
		
		lblFilosofo_Platao = new JLabel("Platão");
		lblFilosofo_Platao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilosofo_Platao.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Platao.setBounds(10, 300, 350, 100);
		lblFilosofo_Platao.setIcon(new ImageIcon("imagens/platao.jpg"));
		lblFilosofo_Platao.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilosofo_Platao.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilosofo_Platao.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFilosofo_Platao);
		
		lblFilosofo_Socrates = new JLabel("Sócrates");
		lblFilosofo_Socrates.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilosofo_Socrates.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Socrates.setBounds(310, 150, 350, 100);
		lblFilosofo_Socrates.setIcon(new ImageIcon("imagens/socrates.jpg"));
		lblFilosofo_Socrates.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilosofo_Socrates.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilosofo_Socrates.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFilosofo_Socrates);
		
		lblFilosofo_Euclides = new JLabel("Euclides");
		lblFilosofo_Euclides.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFilosofo_Euclides.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		lblFilosofo_Euclides.setBounds(600, 300, 350, 100);
		lblFilosofo_Euclides.setIcon(new ImageIcon("imagens/euclides.jpg"));
		lblFilosofo_Euclides.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilosofo_Euclides.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilosofo_Euclides.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFilosofo_Euclides);
				
		btnComecarOJantar = new JButton("Come\u00E7ar O Jantar Dos Fil\u00F3sofos");
		btnComecarOJantar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnComecarOJantar.setBounds(310, 30, 350, 30);
		getContentPane().add(btnComecarOJantar);
		OuvinteMesaDosFilosofos ouvinteMesaDosFilosofos = new OuvinteMesaDosFilosofos(this);
		btnComecarOJantar.addActionListener(ouvinteMesaDosFilosofos);
		
		this.setVisible(true);
	}
}
