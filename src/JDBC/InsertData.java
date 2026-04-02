package JDBC;

import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class InsertData {
     public static void Insertdata() throws ClassNotFoundException, SQLException {
    	 Connection con = JDBCConnection.CreateConn();
    	 Statement stmt = con.createStatement();
//    	 stmt.executeUpdate("DROP TABLE IF EXISTS employee");
        boolean status = stmt.execute("CREATE TABLE employee2 (id INT AUTO_INCREMENT PRIMARY KEY, education VARCHAR(50), joiningYear INT, city VARCHAR(50), paymentTier INT, age INT, gender VARCHAR(10), everBenched VARCHAR(10), experienceInCurrentDomain INT, leaveOrNot INT)");
        
        if(status==false) {
        	 System.out.println("Table Created..");
         }
        else {
       	 System.out.println("Table already exist....");
         }
     }
	 
     // read data from csv  
     
     public static void ReadndandInsert() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
    	 
    	 // Read data from csv 
    	 Connection con = JDBCConnection.CreateConn();     
    	 BufferedReader br = new BufferedReader(new FileReader("Employee.csv"));
    	    String line;

    	    br.readLine(); 

    	    while((line = br.readLine()) != null){

    	        String data[] = line.split(",");
 
    	         
    	        String query = "INSERT INTO employee2(education,joiningYear,city,paymentTier,age,gender,everBenched,experienceInCurrentDomain,leaveOrNot) VALUES (?,?,?,?,?,?,?,?,?)";

    	        PreparedStatement ps = con.prepareStatement(query);

    	        ps.setString(1, data[0]);
    	        ps.setInt(2, Integer.parseInt(data[1]));
    	        ps.setString(3, data[2]);
    	        ps.setInt(4, Integer.parseInt(data[3]));
    	        ps.setInt(5, Integer.parseInt(data[4]));
    	        ps.setString(6, data[5]);
    	        ps.setString(7, data[6]);
    	        ps.setInt(8, Integer.parseInt(data[7]));
    	        ps.setInt(9, Integer.parseInt(data[8]));

    	        ps.executeUpdate();
    	       
    	    }

    	    System.out.println("CSV data inserted successfully");
    	    // get data from csv 
    	    
    	    String query1 = "SELECT * FROM employee2";
    	    PreparedStatement p = con.prepareStatement(query1);
    	    ResultSet rs = p.executeQuery();

    	    System.out.println("Employee data is ....");
    	    while (rs.next()) {
    	        System.out.println(
    	            rs.getInt("id") + " , " +                     // AUTO_INCREMENT id
    	            rs.getString("education") + " , " +
    	            rs.getInt("joiningYear") + " , " +
    	            rs.getString("city") + " , " +
    	            rs.getInt("paymentTier") + " , " +
    	            rs.getInt("age") + " , " +
    	            rs.getString("gender") + " , " +
    	            rs.getString("everBenched") + " , " +
    	            rs.getInt("experienceInCurrentDomain") + " , " +
    	            rs.getInt("leaveOrNot")                        
    	        );
    	    }
    	    	
    	    }
    	
     //  Employees per city
     public static void employeesPerCity() throws Exception {
    	 Connection con = JDBCConnection.CreateConn();
         String query = "SELECT city, COUNT(*) AS total FROM employee2 GROUP BY city ORDER BY total DESC";
         try (PreparedStatement ps = con.prepareStatement(query);
              ResultSet rs = ps.executeQuery()) {
             System.out.println("Employees per city:");
             while (rs.next()) {
                 System.out.println(rs.getString("city") + " : " + rs.getInt("total"));
             }
         }
     }
     public static void avgPaymentByEducation() throws Exception {
    	 Connection con = JDBCConnection.CreateConn();
         String query = "SELECT education, AVG(paymentTier) AS avgPayment FROM employee2 GROUP BY education ORDER BY avgPayment DESC";
         try (PreparedStatement ps = con.prepareStatement(query);
              ResultSet rs = ps.executeQuery()) {
             System.out.println("Average Payment Tier by Education:");
             while (rs.next()) {
                 System.out.println(rs.getString("education") + " : " + rs.getDouble("avgPayment"));
             }
         }
     }
     
//     SELECT * FROM employee WHERE experienceInCurrentDomain > 5;
//     Filter employees with high experience:
     public static void HighexperienceEmployee() throws ClassNotFoundException, SQLException {
    	 Connection con = JDBCConnection.CreateConn();
    	 String query = "SELECT * from employee2 WHERE experienceINCurrentDomain>5";
    	 
    	 PreparedStatement p = con.prepareStatement(query);
    	 ResultSet rs = p.executeQuery();
    	 
    	 System.out.println("Filter employees with high experience:");
    	 
    	 while(rs.next()) {
    		 System.out.println(
    	                "ID: " + rs.getInt("id") +
    	                ", Education: " + rs.getString("education") +
    	                ", Experience: " + rs.getInt("experienceInCurrentDomain")
    	            );
    	 }
     }
     
     
     public static void deleteEmployee() throws ClassNotFoundException, SQLException {
    	    try (Connection con = JDBCConnection.CreateConn();
    	         PreparedStatement p = con.prepareStatement(
    	                 "DELETE FROM employee2 WHERE everBenched = 'Yes' AND leaveOrNot = 1")) {

    	        int rowsDeleted = p.executeUpdate();  // ✅ returns number of rows deleted
    	        System.out.println("Number of employees deleted: " + rowsDeleted);

    	        // Optional: Display remaining employees
    	        String selectQuery = "SELECT * FROM employee2";
    	        try (PreparedStatement psSelect = con.prepareStatement(selectQuery);
    	             ResultSet rs = psSelect.executeQuery()) {

    	            System.out.println("Remaining employees:");
    	            while (rs.next()) {
    	                System.out.println(
    	                        "ID: " + rs.getInt("id") +
    	                        ", Education: " + rs.getString("education") +
    	                        ", Experience: " + rs.getInt("experienceInCurrentDomain") +
    	                        ", EverBenched: " + rs.getString("everBenched") +
    	                        ", Leave: " + rs.getInt("leaveOrNot")
    	                );
    	            }
    	        }
    	    }
    	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//       Insertdata();
//		ReadndandInsert();
		
//		employeesPerCity();
//		avgPaymentByEducation();
		
//		HighexperienceEmployee();
		deleteEmployee();
		
	}

}
