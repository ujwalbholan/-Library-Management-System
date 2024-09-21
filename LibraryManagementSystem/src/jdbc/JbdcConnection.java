package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JbdcConnection {

	public static final String url = "jdbc:mysql://localhost:3306/library_management?useSSL=false"; // in place of library_management use your own database name
	public static final String user = ""; // use your own db username
	public static final String password = "";// use your own db password
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,user,password);
		}catch( SQLException e) {
			System.out.println("connection failed :"+e.getMessage());
		}
		return con;
	}
}
