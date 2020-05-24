package PGL.pglp_5_2;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Akram
 *
 */
public class PersonnelJDBC extends DAO<Personnel>{
	/**
	 * connection
	 */
	 private Connection connexion = null;
	  /**
	   *  statement.
	   */
	  private Statement statement;
	/**
	 * Constructor
	 */
	public PersonnelJDBC() {
		  connexion = this.getConnection();
		    try {
		      ResultSet res = connexion.getMetaData().getTables(null,null,"Personnels".toUpperCase(),null);
		      statement = (Statement) connexion.createStatement();
		      if (!res.next()) {
		    	  ((java.sql.Statement)statement).execute("create table PERSONNEL(nom varchar(50)"
		        					+ "NOT NULL PRIMARY KEY, " 
		        					+ " prenom  varchar(50) NOT NULL, fonction varchar(50) ,"
		        					+ "id_groupe integer));");
		      }
		      ((Connection) statement).close();
		      connexion.close();
		    } catch (SQLException e1) {
		      e1.printStackTrace();
		    }
	}
	@Override
	public Personnel create(Personnel a) throws FileNotFoundException, IOException {
		 connexion = this.getConnection();
		    PreparedStatement create =  null;
		    int stat = 0;
		    String insertString = "insert into PERSONNEL(nom, prenom, fonction, id_groupe) values (?,?,?,?)";
		    try {
		      create = connexion.prepareStatement(insertString);
		      create.setString(1, a.getNom());
		      create.setString(2, a.getPrenom());
		      create.setString(3, a.getFonction());
		      create.setInt(4, a.getId());
		      stat = create.executeUpdate();
		      connexion.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    try {
		      if (create != null) {
		        create.close();
		      }
		    } catch (SQLException e1) {
		      e1.printStackTrace();
		    }
		    if (stat > 0) {
		      return a;
		    } else {
		      return null;
		    }}

	@Override
	public void delete(Personnel obj) {
		connexion = this.getConnection();
	    PreparedStatement delete =  null;
	    String deleteString = "delete from PERSONNEL where nom =(?)";
	    try {
	      delete = connexion.prepareStatement(deleteString);
	      delete.setString(1, obj.getNom());
	      delete.executeUpdate();
	      connexion.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    try {
	      if (delete != null) {
	        delete.close();
	      }
	    } catch (SQLException e1) {
	      e1.printStackTrace();
	    }		
	}

	@Override
	public Personnel update(Personnel a) throws IOException {
		connexion = this.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update PERSONNEL set prenom = (?), "
	        + "fonction = (?), id_groupe = (?) where nom =(?)";
	    try {
	      update = connexion.prepareStatement(updateString);
	      update.setString(1, a.getPrenom());
	      update.setString(2, a.getFonction());
	      update.setInt(3, a.getId());
	      update.setString(4, a.getNom());
	      update.executeUpdate();
	      connexion.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    try {
	      if (update != null) {
	        update.close();
	      }
	    } catch (SQLException e1) {
	      e1.printStackTrace();
	    }
	    return a;	
	    
	}

	@Override
	public Personnel find(String nom1) throws IOException, ClassNotFoundException {
		connexion = this.getConnection();
	    PreparedStatement find =  null;
	    Personnel ps = null;
	    ResultSet resultat = null;
	    String findString = "select * from PERSONNEL where nom = (?)"; 
	    try {
	      find = connexion.prepareStatement(findString);
	      find.setString(1, nom1);
	      find.execute();
	      resultat = find.getResultSet();
	      if (resultat.next()) {
	        String nom = resultat.getString("nom");
	        String prenom = resultat.getString("prenom");
	        String fonction = resultat.getString("Fonction");
	        int idG = resultat.getInt("id_grouope");
	        ps = new Personnel.PBuilder(nom, prenom, fonction,null, idG).build();
	        connexion.close();
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    try {
	      if (find != null) {
	        find.close();
	      }
	    } catch (SQLException e1) {
	      e1.printStackTrace();
	    }
	    return ps;		
	}
	/**
	 * get connection
	 * @return connection
	 */
	public Connection getConnection() {
	    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	    try {
	      Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
	      connexion = DriverManager.getConnection("jdbc:derby:sarradb;create=true");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return connexion;
	  }
}
