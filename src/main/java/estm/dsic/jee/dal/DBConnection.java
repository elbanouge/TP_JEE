package estm.dsic.jee.dal;

import java.sql.*;

public class DBConnection {

	public static Connection getConnection() {
		Connection connection = null;

		/*try {

			//Class.forName("com.mysql.cj.jdbc.Driver");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionusers", "root", "admin");

			Context context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:comp/env/jdbc/gestionusers");
			connection = source.getConnection();
			System.out.println("Connection succes");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		return connection;
	}
}
