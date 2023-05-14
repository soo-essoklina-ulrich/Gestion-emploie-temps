package Interface_sans_MVC;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class Dash {

	public JFrame frmEmploieDuTps;
	private JTable table;
	private An_sco an_sco;
	private Classe classe;
	private Enseigant enseigant;
	private Matiere matiere;
//	private connect con;
	
	public String date() {
		
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-mm-yy");
		String days = s.format(date);
		return days;
	}


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Dash window = new Dash();
//					window.frmEmploieDuTps.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	/**
	 * Create the application. 
	 */
	public Dash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}

		frmEmploieDuTps = new JFrame();
		frmEmploieDuTps.setIconImage(Toolkit.getDefaultToolkit().getImage(Dash.class.getResource("/image/liste.jpg")));
		frmEmploieDuTps.getContentPane().setBackground(new Color(194, 235, 216));
		frmEmploieDuTps.getContentPane().setLayout(null);
				
		JPanel Title = new JPanel();
		Title.setBounds(134, 58, 411, 44);
		Title.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 4, true), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 116, 136)));
		Title.setBackground(new Color(138, 217, 180));
		Title.setLayout(null);
		
		JLabel title_lbl = new JLabel("GESTION");
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		title_lbl.setVerifyInputWhenFocusTarget(false);
		title_lbl.setForeground(new Color(255, 255, 255));
		title_lbl.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 32));
		title_lbl.setBounds(30, 0, 336, 44);
		Title.add(title_lbl);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(10, 58, 90, 325);
		panelBtn.setBackground(SystemColor.inactiveCaption);
		panelBtn.setLayout(null);
		frmEmploieDuTps.getContentPane().add(panelBtn);
		
		JButton Ens = new JButton("Prof...");
		Ens.setBounds(10, 54, 70, 23);
		Ens.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enseigant = new Enseigant();
				enseigant.frame.setVisible(true);
				
			}
		}); 
		
		panelBtn.add(Ens);
		
		JButton matierebtn = new JButton("Matiére");
		matierebtn.setBounds(10, 217, 70, 23);
		matierebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				matiere = new Matiere();
				matiere.frame.setVisible(true);
				
			}
		});
		
		panelBtn.add(matierebtn);
		
		JButton classetbn = new JButton("Classe");
		classetbn.setBounds(10, 102, 70, 23);
		classetbn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				classe = new Classe();
				classe.frame.setVisible(true);
				
				
			}
		});
		
		panelBtn.add(classetbn);
		
		JButton cour = new JButton("Cours");
		cour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cours cours = new Cours();
				cours.frame.setVisible(true);
				
			}
		});
		cour.setBounds(10, 159, 70, 23);
		panelBtn.add(cour);
		
		JButton An = new JButton("Année");
		An.setBounds(10, 281, 70, 23);
		An.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				an_sco = new An_sco();
				an_sco.frame.setVisible(true);
				
			}
		});
		panelBtn.add(An);
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Elements");
		lblNewLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(new Color(0, 102, 204));
		lblNewLabel.setFont(new Font("DialogInput", Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 11, 70, 23);
		panelBtn.add(lblNewLabel);
		
		
		frmEmploieDuTps.getContentPane().add(Title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 135, 465, 287);
		frmEmploieDuTps.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setVerifyInputWhenFocusTarget(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPane.setViewportView(table);
		
		JPanel top_bar = new JPanel();
		top_bar.setBounds(10, 0, 607, 35);
		frmEmploieDuTps.getContentPane().add(top_bar);
		top_bar.setLayout(null);
		
		JLabel hours = new JLabel();
		hours.setHorizontalAlignment(SwingConstants.CENTER);
		hours.setFont(new Font("Sitka Text", Font.BOLD, 14));
		new Timer(0, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Date heure = new Date();
						SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
						String timeString = s.format(heure);
						hours.setText(timeString);
					}
				}).start();
		
		
		
		hours.setBounds(510, 10, 87, 25);
		top_bar.add(hours);


		
		
		JLabel Days = new JLabel( date());
		
		Days.setOpaque(true);
		Days.setFont(new Font("Sitka Small", Font.BOLD, 14));
		
		Days.setBounds(10, 0, 87, 35);
		top_bar.add(Days);
		frmEmploieDuTps.setTitle("Emploie du tps");
		frmEmploieDuTps.setBackground(Color.BLACK);
		frmEmploieDuTps.setBounds(100, 100, 643, 472);
		frmEmploieDuTps.setLocationRelativeTo(null);
		frmEmploieDuTps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
