package sakk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jconnection {
     public static Connection create() throws ClassNotFoundException, SQLException {
		
    	 Connection con = null;
    	 Class.forName("com.mysql.cj.jdbc.Driver");
	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Javaconn","root","Root@06");
    	 
    	 System.out.println("Connection created successfully");
//    	 con.close();
		 return con;
     }
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		create();

	}

}
