package Interface_sans_MVC;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Cours {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Cours window = new Cours();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Cours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(84, 162, 184));
		frame.setBounds(100, 100, 522, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Matierelbl = new JLabel("Matiere");
		Matierelbl.setVerticalAlignment(SwingConstants.CENTER);
		Matierelbl.setBounds(38, 29, 56, 18);
		frame.getContentPane().add(Matierelbl);
		
		JLabel Enseignantlbl = new JLabel("Enseignant");
		Enseignantlbl.setBounds(38, 67, 56, 18);
		frame.getContentPane().add(Enseignantlbl);
		
		JLabel classelbl = new JLabel("Classe");
		classelbl.setBounds(38, 110, 56, 18);
		frame.getContentPane().add(classelbl);
		
		JLabel Annelbl = new JLabel("Année");
		Annelbl.setBounds(38, 157, 56, 18);
		frame.getContentPane().add(Annelbl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(184, 25, 81, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(184, 63, 81, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(184, 106, 81, 22);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(184, 153, 81, 22);
		frame.getContentPane().add(comboBox_3);
		
		JPanel panel_image = new JPanel();
		panel_image.setBounds(300, 11, 196, 285);
		frame.getContentPane().add(panel_image);
		
		JButton Plus = new JButton("Submit");
		Plus.setBounds(76, 240, 89, 23);
		frame.getContentPane().add(Plus);
	}
}
