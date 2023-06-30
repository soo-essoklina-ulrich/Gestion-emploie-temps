package Interface_sans_MVC;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cours {

	public JFrame frame;
	private connect connect = new connect();

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(84, 162, 184));
		frame.setBounds(100, 100, 379, 323);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JComboBox Ma_Box = new JComboBox();
		Ma_Box.setBounds(184, 25, 145, 22);
		frame.getContentPane().add(Ma_Box);
		
		JComboBox En_Box = new JComboBox();
		En_Box.setBounds(184, 63, 145, 22);
		frame.getContentPane().add(En_Box);
		
		JComboBox Cl_Box = new JComboBox();
		Cl_Box.setBounds(184, 106, 145, 22);
		frame.getContentPane().add(Cl_Box);
		
		JComboBox An_Box = new JComboBox();
		An_Box.setBounds(184, 153, 145, 22);
		frame.getContentPane().add(An_Box);
		
		try {
			addItem(En_Box, Ma_Box, Cl_Box, An_Box);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton Plus = new JButton("Submit");
		Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String En = (String) En_Box.getSelectedItem();
		        String Ma = (String) Ma_Box.getSelectedItem();
		        String cl = (String) Cl_Box.getSelectedItem();
		        String An = (String) An_Box.getSelectedItem();
		        try {
					connect.insert_Cours2(Ma, En, cl, An);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Plus.setBounds(76, 240, 89, 23);
		frame.getContentPane().add(Plus);
	}
	
	private void addItem(JComboBox boxEn,JComboBox boxMa,JComboBox boxCl,JComboBox boxAn) throws SQLException {
		connect.One_Enseigant();

		while (connect.rs.next()) {
			boxEn.addItem(connect.rs.getString("nom"));
			
		}
		connect.ONE_Matieres();
		while (connect.rs.next()) {
			boxMa.addItem(connect.rs.getString("intitule"));
			
		}
		connect.ONE_Classes();
		while (connect.rs.next()) {
			boxCl.addItem(connect.rs.getString("intitule"));
			
		}
		connect.ONE_AnneesScolaires();
		while (connect.rs.next()) {
			boxAn.addItem(connect.rs.getObject("code"));
		}
	}
}
