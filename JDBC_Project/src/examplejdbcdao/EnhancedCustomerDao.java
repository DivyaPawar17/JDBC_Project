package examplejdbcdao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;


import examplejdbcentity.Customer;
import examplejdbcutils.JdbcUtils;


public class EnhancedCustomerDao extends CustomerDao {
	public Collection<Customer> retrieveAllCustomerByCityName(String cityName){
		Collection <Customer>allCustomerWithMatchingCityName = new ArrayList<>();
		String sqlQuery = "select custid, cname, address from customer1 where cname=?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				){
		pstmt.setString(1, cityName);
		//pstmt.executeQuery();
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString(2);
			String address = rs.getString(3);
			int id = rs.getInt(1);
			// population an object of customer class based
			// upon : ID, name and address
			Customer currentCustomer = new Customer(id, name, address);
			// Adding this object into customer's collection
			allCustomerWithMatchingCityName.add(currentCustomer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return allCustomerWithMatchingCityName;
	}

}

