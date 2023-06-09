package Interface_sans_MVC;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class loginface {

	public static JFrame frame;
	public static String user;
	public static String  password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginface window = new loginface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(84, 162, 184));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE
				);
		frame.getContentPane().setLayout(null);
		
		JLabel userlbl = new JLabel("USER");
		userlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userlbl.setBounds(55, 40, 46, 14);
		frame.getContentPane().add(userlbl);
		
		JLabel passlbl = new JLabel("Password");
		passlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passlbl.setBounds(55, 130, 81, 14);
		frame.getContentPane().add(passlbl);
		
		JTextField textField = new JTextField();
		textField.setDropMode(DropMode.INSERT);
		textField.setBounds(170, 37, 120, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(170, 127, 120, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = textField.getText();
				password = passwordField.getText();
				
				try {
					log();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(119, 172, 215));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(183, 201, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblheureLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblheureLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblheureLabel.setBounds(353, 0, 81, 20);
		new Timer(0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date heure = new Date();
				SimpleDateFormat s = new SimpleDateFormat("HH:mm");
				String timeString = s.format(heure);
				lblheureLabel.setText(timeString);
			}
		}).start();
		frame.getContentPane().add(lblheureLabel);
		
		
	}
	
	
	
	
	private  static void log() throws SQLException {
		connect connect = new connect();
		connect.conect();
		String query = "SELECT * FROM user WHERE userman LIKE ?";
		connect.pst = connect.con.prepareStatement(query);
		connect.pst.setString(1, user);
		connect.rs = connect.pst.executeQuery();
//		while (connect.rs.next()) {
//			if (connect.rs.getString("userman").equals(user) && connect.rs.getString("pass").equals(password)) {
//				
//				Dash dash = new Dash();
//				dash.frmEmploieDuTps.setVisible(true);
//			}else {
//				JOptionPane.showMessageDialog(null, "user or password wrong\n RETRY");
//			}
//		}
//		
		
		if (connect.rs.next()) {
            // Des résultats ont été trouvés, faire quelque chose avec les résultats
			if (connect.rs.getString("userman").equals(user)) {
				
				if (connect.rs.getString("pass").equals(password)) {
					JOptionPane.showMessageDialog(null, "welcome "+user+" !");
					try {
						frame.dispose();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Dash dash = new Dash();
					dash.frmEmploieDuTps.setVisible(true);
				}else {
					
					JOptionPane.showMessageDialog(null, "user or password wrong\n RETRY","Login", 0, null);
				}
			}else {
				JOptionPane.showMessageDialog(null, "user or password wrong\n RETRY","Login", 0, null);
			}
           
        } else {
            // Aucun résultat trouvé, afficher un message à l'utilisateur
           JOptionPane.showMessageDialog(null, "vous n'ete pas enregistrer","Login", 0, null);
        }
   
		connect.con.close();







	}
}
