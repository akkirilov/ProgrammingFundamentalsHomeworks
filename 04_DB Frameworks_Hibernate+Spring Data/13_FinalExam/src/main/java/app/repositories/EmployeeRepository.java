package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.domain.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("SELECT e FROM Employee AS e "
			+ "WHERE e.branch.products.size >= 1 "
			+ "ORDER BY e.firstName ASC, e.lastName ASC, LENGTH(e.position) DESC")
	List<Employee> findAllProductiveEmployees();
	
}
