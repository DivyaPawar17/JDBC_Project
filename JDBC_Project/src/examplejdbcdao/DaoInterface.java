package examplejdbcdao;

import java.util.Collection;
//This interface provides a basic template for the DAO pattern
//Its Implementation class decides the actual entity type and the ID type.

import examplejdbcentity.Customer;


public interface DaoInterface<T, K> {
		Collection<T> retrieveAll();
		T retrieveOne(K id);
		void create (T t);
		void delete(K id);
		void update(T t);

}
//Customer ID: int-->  Integer--->CustomerDaoCustomer, Integer
//Passport ID: String----> PassportDao<Passport, String>