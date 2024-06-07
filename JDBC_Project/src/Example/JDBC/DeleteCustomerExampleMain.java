package Example.JDBC;

import examplejdbcdao.CustomerDao;
import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;

public class DeleteCustomerExampleMain {
	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef = new CustomerDao();
		daoRef.delete(1);
	}

}
