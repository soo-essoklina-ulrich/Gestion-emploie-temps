package Interface_sans_MVC;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import java.text.SimpleDateFormat;

public class An_sco {

	JFrame frame;
	private JTextField codeField;
	private JDateChooser date_d_Field;
	private JDateChooser date_f_Field;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	connect connect;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					An_sco window = new An_sco();
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
	public An_sco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 391, 291);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Code : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 7, 71, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date de Début : ");

		lblNewLabel_1.setBounds(10, 61, 125, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date de Fin : ");
		lblNewLabel_2.setBounds(20, 116, 105, 24);
		panel.add(lblNewLabel_2);
		
		codeField = new JTextField();
		codeField.setBounds(179, 5, 173, 33);
		panel.add(codeField);
		codeField.setColumns(10);
		
		date_d_Field = new JDateChooser();
		date_d_Field.setBounds(179, 57, 173, 33);
		panel.add(date_d_Field);
		
		
		
		
		date_f_Field = new JDateChooser();
		date_f_Field.setBounds(179, 112, 173, 33);
		panel.add(date_f_Field);
		
		
		Button btn_new = new Button("Enregistrer");
		btn_new.setBackground(new Color(47, 79, 79));
		btn_new.setForeground(new Color(255, 255, 255));
		btn_new.setFont(new Font("Dialog", Font.BOLD, 14));
		btn_new.setBounds(179, 182, 92, 22);
		panel.add(btn_new);
		btn_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		        String date_d = dateFormat.format(date_d_Field.getDate());
		        String date_f = dateFormat.format(date_d_Field.getDate());
				try {
					connect = new connect();
					//connect.conect();
					connect.pst = connect.conect().prepareStatement("insert into AnneesScolaires(code, dateDebut, dateFin) values (?,?,?)");
					connect.pst.setString(1, codeField.getText());
					connect.pst.setString(2, date_d);
					connect.pst.setString(3, date_f);
					connect.pst.executeUpdate();
					connect.con.close();
					JOptionPane.showMessageDialog(null, "la matiére intitulé: "+codeField.getText()+" Ajouter !");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
	}
}
