package examplejdbcutils;



import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	// A utility class used for establishing a Connection
	public static Connection buildConnection() throws Exception{
		
		String URl = "jdbc:mysql://localhost:3306/cdac";
		String UID = "root";
		String PWD = "password";
		Connection dbConnection = DriverManager.getConnection(URl,UID,PWD);
		
		return dbConnection;
		
	}


}
