package Interface_sans_MVC;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

public class Enseigant {

	JFrame frame;
	private JTable table;
	private JTextField nomField;
	private JTextField preField;
	private JTextField telField;
	private JTextField matriculeField;
	private JTextField emailField;
	private connect connect;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Enseigant window = new Enseigant();
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
	public Enseigant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 411);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane);
		
		JPanel liste = new JPanel();
		liste.setToolTipText("");
		tabbedPane.addTab("Liste", null, liste, null);
		liste.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(0, 0, 528, 367);
		liste.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel plus = new JPanel();
		plus.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Plus", null, plus, null);
		plus.setLayout(null);
		
		Button btn_new = new Button("Enregistrer");
		btn_new.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        String nom = nomField.getText();
			        String prenom = preField.getText();
			        String tel = telField.getText();
			        String matricule = matriculeField.getText();
			        String email = emailField.getText();
			        //connexion_bd
			        try {
						connect = new connect();
						//connect.conect();
						connect.pst = connect.conect().prepareStatement("insert into enseignants(nom, prenom, telephone, matricule, email) values (?,?,?,?,?)");
						connect.pst.setString(1, nom);
						connect.pst.setString(2, prenom);
						connect.pst.setString(3, tel);
						connect.pst.setString(4, matricule);
						connect.pst.setString(5, email);
						connect.pst.executeUpdate();
						connect.con.close();
						JOptionPane.showMessageDialog(null, nom+" Ajouter");
						
					} catch (Exception e2) {
						// TODO: handle exception
					}

			        // Faire quelque chose avec les informations renseignées
			        
			        
			    }
		});
		btn_new.setBackground(new Color(47, 79, 79));
		btn_new.setForeground(new Color(255, 255, 255));
		btn_new.setFont(new Font("Dialog", Font.BOLD, 14));
		btn_new.setBounds(240, 265, 92, 22);
		plus.add(btn_new);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 11, 92, 14);
		plus.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prénom :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 52, 92, 14);
		plus.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Téléphone :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(39, 103, 92, 14);
		plus.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numéro matricule :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(23, 151, 128, 14);
		plus.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(39, 201, 92, 14);
		plus.add(lblNewLabel_4);
		
		nomField = new JTextField();
		nomField.setBounds(226, 3, 106, 30);
		plus.add(nomField);
		nomField.setColumns(10);
		
		preField = new JTextField();
		preField.setBounds(226, 44, 106, 30);
		plus.add(preField);
		preField.setColumns(10);
		
		telField = new JTextField();
		telField.setBounds(226, 95, 106, 30);
		plus.add(telField);
		telField.setColumns(10);
		
		matriculeField = new JTextField();
		matriculeField.setBounds(226, 143, 106, 30);
		plus.add(matriculeField);
		matriculeField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(226, 193, 106, 30);
		plus.add(emailField);
		emailField.setColumns(10);
	}
	
}


