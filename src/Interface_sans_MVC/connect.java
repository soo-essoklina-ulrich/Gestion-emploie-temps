package Interface_sans_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class connect {
	/* 
	 * 
	 * public void Connect() throws SQLException { try {
	 * Class.forName("con.mysql.jdbc.Driver"); connection =
	 * DriverManager.getConnection("jdbc:mysql://localhost/gst_temps_bd", "root",
	 * "123456789"); System.out.println("connection etablie"); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	 
	 private static String jdbcUrl = "jdbc:mysql://localhost/gst_temps_bd";
	 private static String user = "root";
	 private static String pass = "123456789";
	 Connection con;
	 PreparedStatement pst;
	 ResultSet rs;
	 
	//Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
	 public  Connection conect() {
		 try {
			 Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			 con=  connection;	
	         // Connexion réussie ! Vous pouvez maintenant interagir avec la base de données ici
	         System.out.println("Connexion à la base de données réussie.");
	         
	         // Exécutez vos requêtes SQL ou effectuez d'autres opérations sur la base de données ici
	         
	     } catch (SQLException e) {
	    	 e.printStackTrace();
	         System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
	     }
		return con;
		
	 }


	 public void close() throws SQLException {
		this.con.close();
		System.out.println("connexion close !!!!!!");
	}
	
/*-----------------------------------------------------------------SELECT FUNCTION--------------------------------------------------
 * _________________________________________________________________________SELECT ONE ITEM____________________________________________*/
	 
	 public ResultSet One_Enseigant() throws SQLException {
		 conect();
			String query = "SELECT nom FROM Enseignants ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
		return rs;
	}
	 public ResultSet ONE_Matieres() throws SQLException {
		 
			conect();
			String query = "SELECT intitule FROM  Matieres ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 public ResultSet ONE_Classes() throws SQLException {
		 
			conect();
			String query = "SELECT intitule FROM Classes ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 public ResultSet ONE_AnneesScolaires() throws SQLException {
		 
			conect();
			String query = "SELECT code FROM AnneesScolaires";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 
	 /*___________________________________________________________________END ONE SELECT ITEM____________________________________*/
	 
	 public ResultSet Enseignant() throws SQLException {
		 
			conect();
			String query = "SELECT * FROM Enseignants ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 
	 public ResultSet Matieres() throws SQLException {
		 
			conect();
			String query = "SELECT * FROM  Matieres ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 public ResultSet Classes() throws SQLException {
		 
			conect();
			String query = "SELECT * FROM Classes ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 public ResultSet AnneesScolaires() throws SQLException {
		 
			conect();
			String query = "SELECT * FROM AnneesScolaires";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 public ResultSet Cours() throws SQLException {
		 
			conect();
			String query = "SELECT * FROM Cours";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}

	 public ResultSet EmploisDuTemps() throws SQLException {
		 
			
			String query = "SELECT * FROM EmploisDuTemps ";
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			return rs;
	}
	 
	 
/*-------------------------------------------------------------------------------------------INSERT FUNCTION--------------------------------------------------------*/
	 
	 public void insert_Enseigant(String nom, String prenom, String tel, String matricule,  String email) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into enseignants(nom, prenom, telephone, matricule, email) values (?,?,?,?,?)");
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, tel);
			pst.setString(4, matricule);
			pst.setString(5, email);
			pst.executeUpdate();
			close();
	 }
	 public void insert_Matiere(String intitule, String code) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into Matieres(intitule, code) values (?,?)");
			pst.setString(1, intitule);
			pst.setString(2, code);
		
			pst.executeUpdate();
			close();
	 } 
	 
	 public void insert_Classe(String intitule, String code) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into Classes(intitule, code) values (?,?)");
			pst.setString(1, intitule);
			pst.setString(2, code);
			pst.executeUpdate();
			close();
	 }
	 public void insert_AnneesScolaires(String code, String date_d, String date_f) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into AnneesScolaires(code, dateDebut, dateFin) values (?,?,?)");
			pst.setString(1, code);
			pst.setString(2, date_d);
			pst.setString(3, date_f);
			pst.executeUpdate();
			close();
	 }
	 //------------------------------------------------------------>pas Encore Optimiser
	 public void insert_Cours(String nom, String prenom, String tel, String matricule,  String email) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into Cours(nom, prenom, telephone, matricule, email) values (?,?,?,?,?)");
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, tel);
			pst.setString(4, matricule);
			pst.setString(5, email);
			pst.executeUpdate();
			close();
	 }
	 public void insert_Cours2(String Matiere, String Enseignant, String Classe, String Annne) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into Cours2(Matiere, Enseignant, Classe, Anneescolaire) values (?,?,?,?)");
			pst.setString(1, Matiere);
			pst.setString(2, Enseignant);
			pst.setString(3, Classe);
			pst.setString(4, Annne);
			pst.executeUpdate();
			close();
	 }
	 public void insert_Emploidutps(String nom, String prenom, String tel, String matricule,  String email) throws SQLException{
		 conect();
		 pst = con.prepareStatement("insert into EmploisDuTemps(nom, prenom, telephone, matricule, email) values (?,?,?,?,?)");
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, tel);
			pst.setString(4, matricule);
			pst.setString(5, email);
			pst.executeUpdate();
			close();
	 }

}
