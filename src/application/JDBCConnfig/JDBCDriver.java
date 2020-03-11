package application.JDBCConnfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriver {
//	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost;Database=javafx_demo";
	private static String user = "sa";
	private static String password = "12345";
	public Connection run() throws SQLException {
			Connection connect = DriverManager.getConnection(url, user, password);
			return connect;
	}
}
