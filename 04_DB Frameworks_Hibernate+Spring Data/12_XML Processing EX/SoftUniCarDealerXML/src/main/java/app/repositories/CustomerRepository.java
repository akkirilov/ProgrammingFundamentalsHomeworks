package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findAllByOrderByBirthDateAsc();
	
	@Query("SELECT c FROM Customer AS c WHERE c.sales.size > 0")
	List<Customer> findAllWithCars();
	
}
