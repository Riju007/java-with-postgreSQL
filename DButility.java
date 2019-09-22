import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

import java.util.ArrayList;
import java.util.Properties;

import java.io.InputStream;
import java.io.FileInputStream;

public class DButility {
	private static InputStream in = null;
	private static Properties properties = new Properties();
	
	public ArrayList<Actor> getResultSet(String url, String user, String password) throws SQLException{
		
		Connection con = null;
		ResultSet rs = null;
		Statement statement = null;
		ArrayList<Actor> actor = new ArrayList<Actor>();

		try {
			//Class.forName("org.postgresql.Driver"); //not required for JDK 6 and after
			con = DriverManager.getConnection(url, user, password);
			statement = con.createStatement();
			rs = statement.executeQuery(Constants.QUERY);
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String last_udate_time = rs.getString(4);
				Actor obj = new Actor(id, firstName, lastName, last_udate_time);
				actor.add(obj);
			}
			
		}
		//catch(ClassNotFoundException c) {
			//System.out.println(c.getMessage());
		//}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			con.close();
			statement.close();
			rs.close();
		}
		return actor;
	}
	
	public static void main(String[] args) throws Exception {
		in = new FileInputStream(Constants.PROPERTY_FILE);
		properties.load(in);
		DButility dbUtility = new DButility();
		ArrayList<Actor> actorList = dbUtility.getResultSet(properties.getProperty(Constants.URL), properties.getProperty(Constants.USER), properties.getProperty(Constants.PASSWORD));
		actorList.forEach(actor -> System.out.println(actor));
	}
}
