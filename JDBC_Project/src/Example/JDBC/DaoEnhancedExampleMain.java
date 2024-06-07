package Example.JDBC;


	import java.util.Collection;

	import examplejdbcdao.EnhancedCustomerDao;
	import examplejdbcentity.Customer;

	public class DaoEnhancedExampleMain {

			public static void main(String[] args) {
				EnhancedCustomerDao enhancedDaoRef = new EnhancedCustomerDao();
				Collection<Customer> customersWithMatchingCity = 
				enhancedDaoRef.retrieveAllCustomerByCityName("Gauri");
				int size = customersWithMatchingCity.size();
				if(size !=0) {
				for(Customer customerRef : customersWithMatchingCity)
					System.out.println(customerRef);
				}else {
					System.out.println("No Employee Found");
				}
			}

		}

