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


	 
	
	 
	 




}
