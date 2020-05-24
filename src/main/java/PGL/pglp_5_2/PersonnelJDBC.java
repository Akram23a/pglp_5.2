package PGL.pglp_5_2;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
	public Personnel create(Personnel obj) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personnel obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personnel update(Personnel obj) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel find(int id) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
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
