package Example.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExampleMain {
	
	public static void main(String[] args) {
		Connection dbConnection = null;
		Statement stmt =null;
		ResultSet rs = null;
		
		
		try {
			//Load the Driver
			String driverClassName = "com.mysql.cj.jdbc.Driver";
			//com.mysql.cj.jdbc.----> Package Name      Driver---->class Name
		
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");
			
			//Establish Connection
			String URl = "jdbc:mysql://localhost:3306/cdac";
			String UID = "root";
			String PWD = "password";
			dbConnection = DriverManager.getConnection(URl,UID,PWD);
			System.out.println("Connected..");
			
			//obtain some statement
			 stmt = dbConnection.createStatement();
			
			//execute sql query
			String sqlQuery = " select cname, address, custid from customer_master";
			 rs = stmt.executeQuery(sqlQuery);
			
			
			//perform navigation
			while(rs.next()) {
				
				String name = rs.getString(1);
				String address = rs.getString(2);
				int id =rs.getInt(3);
				System.out.println(" ID: " + id + ", Name: "+ name + " Address: "+ address);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//forName() ----> throw -->ClassNotFoundException
		finally {
			//Closing all the resources
			try {
			rs.close();
			stmt.close();
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
}