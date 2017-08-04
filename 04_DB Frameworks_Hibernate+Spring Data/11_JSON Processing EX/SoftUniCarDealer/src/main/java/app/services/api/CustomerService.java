package app.services.api;

import java.util.List;

import app.entities.Customer;

public interface CustomerService {
	
	void save(Customer entity);
	
	void save(List<Customer> entities);
	
	List<Customer> findAll();
	
	Customer findById(Long id);

	List<Customer> findAllByOrderByBirthDateAsc();
	
}
