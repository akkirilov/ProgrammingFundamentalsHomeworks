package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Customer;
import app.repositories.CustomerRepository;
import app.services.api.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public void save(Customer entity) {
		repository.save(entity);
	}

	@Override
	public void save(List<Customer> entities) {
		repository.save(entities);
	}

	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Customer> findAllByOrderByBirthDateAsc() {
		return repository.findAllByOrderByBirthDateAsc();
	}

}
