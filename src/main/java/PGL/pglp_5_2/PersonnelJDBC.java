package PGL.pglp_5_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Akram
 *
 */
public class PersonnelJDBC extends DAO<Personnel>{

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
	    Connection connexion = null;
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
