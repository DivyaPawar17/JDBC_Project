package Example.JDBC;


import examplejdbcdao.CustomerDao;
import examplejdbcdao.DaoInterface;
import examplejdbcentity.Customer;

public class CreacteNewCustomerExampleMain {

	public static void main(String[] args) {
		DaoInterface<Customer, Integer> daoRef =new CustomerDao();
		Customer customerObj = new  Customer(3,"Divya","Pune");
		daoRef.create(customerObj);
	}

}



