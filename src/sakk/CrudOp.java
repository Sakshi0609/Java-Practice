package sakk;

import java.sql.*;

public class CrudOp {
	//createtable
	public static void createTable() throws ClassNotFoundException, SQLException {
		Connection con = Jconnection.create();
		//Statement creation
		
		Statement stmt = con.createStatement();
		
		// statement execution 
		// stored query in varible to check created or not and boolean because excute give result set in true false 
		 boolean status = stmt.execute("create table studr(id int , name varchar(20),city varchar(20))");
		 if(status == false) {
			 System.out.println("table craeted.");
		 }else {
			 System.out.println("Table already exsist");
		 }
		con.close();
	}
	
	
	// Insert data into table
	public static void saveData() throws ClassNotFoundException, SQLException {
//		Connection code which is return in another file that called ..
		Connection con =Jconnection.create();
		
		Statement stmt = con.createStatement();
		
		int status = stmt.executeUpdate("Insert into studr values(4,'Adii','Nashik')");
		if(status==1) {
			System.out.println("data saved");
		}
		else {
			System.out.println("Data not saved");
		}
		
		
	}
	// Read data from table single value orr if you give id autoincrement then you can read all the data without adding another entity.
	public static void getdata() throws ClassNotFoundException, SQLException {
		
		Connection con= Jconnection.create();
		
		Statement stmt = con.createStatement();
		
		String query =("select * from studr");
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Data is :");
			int id = rs.getInt("id");
	        String name = rs.getString("name");
	        String city = rs.getString("city");
	        
	        System.out.println("Id: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("City: " + city);
		}
		
	}
	
	// Gettalldata from table
	public static void getAlldata() {
		
	}
	
	
	// Update data 
	
	public static void updateData() throws ClassNotFoundException, SQLException {
		Connection con = Jconnection.create();
		Statement stmt = con.createStatement();
		
		int status = stmt.executeUpdate("update studr set name = 'sakk' where id=1");
		if(status==1) {
			System.out.println("Data update");
		}
		else {
			System.out.println("Data not updated");
		}
				
	}
	
//	 delete data of student
	
	public static void deletedata() throws ClassNotFoundException, SQLException {
		Connection con = Jconnection.create();
		Statement stmt = con.createStatement();
		
		int status = stmt.executeUpdate("DELETE FROM studr WHERE name='sakk' AND id=1");
		if(status==1)
			
		{
			System.out.println("data delete");
			
		}
		else {
			System.out.println("Data not found...");
		}
		
	}
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//    	createTable();
//    	saveData();
    	getdata();
//    	updateData();
//    	deletedata();
    }
}
