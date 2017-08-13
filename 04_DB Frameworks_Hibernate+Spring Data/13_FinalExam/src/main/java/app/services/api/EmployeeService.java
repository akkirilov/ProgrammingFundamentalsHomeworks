package app.services.api;

import java.util.List;

import app.domain.dtos.employees.EmployeeJsonDto;
import app.domain.dtos.employees.EmployeeWrapperXmlDto;
import app.domain.entities.Employee;

public interface EmployeeService {

	void save(Employee employee);
	
	void save(List<Employee> employees);
	
	List<Employee> findAll();
	
	Employee findOneById(Long id);
	
	Long count();

	void saveFromDto(EmployeeWrapperXmlDto wrapperXmlDto);

	List<EmployeeJsonDto> findProductiveEmployees();
	
}
