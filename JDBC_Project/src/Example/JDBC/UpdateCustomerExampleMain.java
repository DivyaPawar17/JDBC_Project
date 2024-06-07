package Example.JDBC;

import examplejdbcdao.CustomerDao;
import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;

public class UpdateCustomerExampleMain {

	public static void main(String[] args) {
		DaoInterface<Customer, Integer>daoRef;
		daoRef=new CustomerDao();
		Customer customerRef = daoRef.retrieveOne(6);
		customerRef.setName("Chandrakant");
		daoRef.update(customerRef);

	}

}
