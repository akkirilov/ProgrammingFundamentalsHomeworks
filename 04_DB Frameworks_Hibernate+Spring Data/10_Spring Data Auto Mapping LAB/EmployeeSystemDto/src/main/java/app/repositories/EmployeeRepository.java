package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Employee;
import app.entities.EmployeeNamesInterface;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findFirstByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("SELECT e.firstName AS firstName, e.lastName AS lastName, e.address.street AS street FROM Employee AS e")
	List<EmployeeNamesInterface> findAllEmployeeNames();

}
