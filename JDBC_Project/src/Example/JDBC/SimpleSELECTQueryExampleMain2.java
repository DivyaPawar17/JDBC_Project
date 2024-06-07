package Example.JDBC;

import java.util.Collection;

import examplejdbcdao.CustomerDao;
import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;

public class SimpleSELECTQueryExampleMain2 {

	
	public static void main(String[] args) {
		DaoInterface<Customer, Integer>daoRef;
		daoRef=new CustomerDao();
		Collection<Customer>allCustomers = daoRef.retrieveAll();
		for(Customer cust : allCustomers) {
			System.out.println(cust);
		}

	}

}

