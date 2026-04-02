package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	
	public static Connection CreateConn() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Javajdbc","root","Root@06");
		
		System.out.println("Connection Created..");
//		con.close();
		return con;
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        CreateConn();
	}
}
