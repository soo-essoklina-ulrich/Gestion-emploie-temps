package Interface_sans_MVC;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Matiere {

	JFrame frame;
	private JTable table;
	connect connect;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Matiere window = new Matiere();
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
	public Matiere() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 297);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane);
		
		JPanel liste = new JPanel();
		liste.setToolTipText("");
		tabbedPane.addTab("Liste", null, liste, null);
		liste.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setBounds(0, 0, 434, 253);
		liste.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel plus = new JPanel();
		plus.setBackground(new Color(245, 245, 245));
		tabbedPane.addTab("Plus", null, plus, null);
		plus.setLayout(null);
		
		Label intitule_lbl = new Label("Intitulé : ");
		intitule_lbl.setAlignment(Label.CENTER);
		intitule_lbl.setBounds(10, 10, 62, 22);
		plus.add(intitule_lbl);
		
		Label code_lbl = new Label("Code :");
		code_lbl.setAlignment(Label.CENTER);
		code_lbl.setBounds(10, 104, 62, 22);
		plus.add(code_lbl);
		
		TextField intitule_mat = new TextField();
		intitule_mat.setBounds(154, 10, 120, 29);
		plus.add(intitule_mat);
		
		TextField code_mat = new TextField();
		code_mat.setBounds(154, 104, 120, 22);
		plus.add(code_mat);
		
		Button btn_new = new Button("Enregistrer");
		btn_new.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					connect = new connect();
					//connect.conect();
					connect.pst = connect.conect().prepareStatement("insert into classes(intitule, code) values (?,?)");
					connect.pst.setString(1, intitule_mat.getText());
					connect.pst.setString(2, code_mat.getText());
					connect.pst.executeUpdate();
					connect.con.close();
					JOptionPane.showMessageDialog(null, "la matiére intitulé: "+intitule_mat+" Ajouter");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		});
		btn_new.setBackground(new Color(47, 79, 79));
		btn_new.setForeground(new Color(255, 255, 255));
		btn_new.setFont(new Font("Dialog", Font.BOLD, 14));
		btn_new.setBounds(154, 160, 92, 22);
		plus.add(btn_new);
	}

}
