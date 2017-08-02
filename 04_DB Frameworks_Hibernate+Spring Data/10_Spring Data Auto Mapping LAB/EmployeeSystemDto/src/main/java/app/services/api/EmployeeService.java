package app.services.api;

import java.util.List;

import app.entities.Employee;
import app.entities.EmployeeDto;
import app.entities.EmployeeNamesDto;
import app.entities.EmployeeNamesInterface;

public interface EmployeeService {
	
	void save(Employee employee);
	
	void save(List<Employee> employees);
	
	Employee findFirstByFirstNameAndLastName(String firstName, String lastName);
	
	Employee findById(Long id);

	List<Employee> findAll();
	
	List<EmployeeNamesInterface> findAllEmployeeNames();

}
