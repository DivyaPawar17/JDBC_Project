package examplejdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;
import examplejdbcutils.JdbcUtils;


public class CustomerDao implements DaoInterface<Customer, Integer> {
	@Override
	public Collection<Customer> retrieveAll() {
		Collection<Customer> allCustomers = new ArrayList<>();
		// Some code to get data from database and fill that into this collection
		String sqlQuery = "select ename, empno, sal from emp2";
		try (Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery)) {
			while (rs.next()) {
				String name = rs.getString(1);
				String address = rs.getString(2);
				int id = rs.getInt(3);
				// population an object of customer class based
				// upon : ID, name and address
				Customer currentCustomer = new Customer(id, name, address);
				// Adding this object into customer's collection
				allCustomers.add(currentCustomer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allCustomers;
	}

	@Override
	public Customer retrieveOne(Integer id) {
		//fetching single customer against ID and returning
		Customer foundCustomer = null;
		String sqlQuery = "select ename, empno, sal from emp2 where empno = ?";		
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				){
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String name = rs.getString(1);
			String address = rs.getString(2);
			int cust_id = rs.getInt(3);
			foundCustomer = new Customer(cust_id, name, address);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundCustomer;
		
		
	}

	@Override
	public void create(Customer customerRef) {
		String sqlQuery = "insert into customer_master values(?, ?, ?)";
		
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				)
		{
			//retrieving data from customerRef
			int custId = customerRef.getCustomerid();
			String custName = customerRef.getName();
			String custAddress = customerRef.getAddress();
			
			//Setting the data in place of unknown parameters
			pstmt.setInt(1, custId);
			pstmt.setString(2, custName);
			pstmt.setString(3, custAddress);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Record Inserted..");
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		
		
	}
	}
	
	@Override
	public void delete(Integer id) {
		String sqlQuery = "delete from customer_master where custid =?";
		
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				)
		{
			pstmt.setInt(1, id);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" Record Deleted...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	@Override
	public void update(Customer modifiedCustomer) {
		String sqlQuery = "update customer_master set cname = ?, address = ? where custid =?";
		int id = modifiedCustomer.getCustomerid();
		String newName = modifiedCustomer.getName();
		String newAddress = modifiedCustomer.getAddress();
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				)
		{
			pstmt.setString(1, newName);
			pstmt.setString(2, newAddress);
			pstmt.setInt(3, id);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount +"record update");
		}catch (Exception ex) {
			ex.printStackTrace();
		}	
	} 
	
	
	}

