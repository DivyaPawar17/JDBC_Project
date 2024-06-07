package Example.JDBC;



import examplejdbcdao.CustomerDao;
import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;


public class RetrieveOneCustomerExampleMain {
	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef = new CustomerDao();
		Customer customerRef = daoRef.retrieveOne(5);
		if(customerRef != null)
			System.out.println(customerRef);
		else
			System.out.println("Customer with given ID does not exist.");

	}

} 