package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Employee;
import app.entities.EmployeeDto;
import app.entities.EmployeeNamesDto;
import app.entities.EmployeeNamesInterface;
import app.repositories.EmployeeRepository;
import app.services.api.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void save(Employee employee) {
		Employee employeeTemp = null;
		employee = this.findFirstByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
		if (employeeTemp == null) {
			employeeRepository.save(employee);
		}
	}

	@Override
	public void save(List<Employee> employees) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employeeTemp = null;
			employeeTemp = this.findFirstByFirstNameAndLastName(employees.get(i).getFirstName(), employees.get(i).getLastName());
			if (employeeTemp != null) {
				employees.remove(i);
				i--;
			}
		}
		employeeRepository.save(employees);		
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee findFirstByFirstNameAndLastName(String firstName, String lastName) {
		return employeeRepository.findFirstByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<EmployeeNamesInterface> findAllEmployeeNames() {
		return employeeRepository.findAllEmployeeNames();
	}
	
}
