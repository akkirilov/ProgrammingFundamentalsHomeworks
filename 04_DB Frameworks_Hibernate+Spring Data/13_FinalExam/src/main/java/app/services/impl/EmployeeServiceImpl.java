package app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.dtos.employees.EmployeeJsonDto;
import app.domain.dtos.employees.EmployeeWrapperXmlDto;
import app.domain.dtos.employees.EmployeeXmlDto;
import app.domain.entities.Employee;
import app.repositories.EmployeeRepository;
import app.services.api.BranchService;
import app.services.api.EmployeeCardService;
import app.services.api.EmployeeService;
import app.utils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repository;
	private BranchService branchService;
	private EmployeeCardService employeeCardService;
	
	private Mapper mapper;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository, 
							BranchService branchService,
							EmployeeCardService employeeCardService,
							Mapper mapper) {
		super();
		this.repository = repository;
		this.branchService = branchService;
		this.employeeCardService = employeeCardService;
		this.mapper = mapper;
	}

	@Override
	public void save(Employee employee) {
		try {
			repository.save(employee);
			System.out.println("Successfully imported "
					+ employee.getClass().getSimpleName() + " "
					+ employee.getFirstName() + " "
					+ employee.getLastName() + ".");			
		} catch (Exception e) {
			System.out.println("Error. Invalid data.");		
		}
	}
	
	@Override
	public void save(List<Employee> employees) {
		for (Employee e : employees) {
			this.save(e);			
		}
	}
	
	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findOneById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void saveFromDto(EmployeeWrapperXmlDto wrapperXmlDto) {
		for (EmployeeXmlDto dto : wrapperXmlDto.getEmployeeXmlDtos()) {
			Employee temp = mapper.mapOne(dto, Employee.class);
			temp.setBranch(branchService.findOneByName(dto.getBranch()));
			temp.setEmployeeCard(employeeCardService.findOneByNumber(dto.getCard()));
			this.save(temp);
		}
	}

	@Override
	public List<EmployeeJsonDto> findProductiveEmployees() {
		List<EmployeeJsonDto> dtos = new ArrayList<>();
		List<Employee> employees = repository.findAllProductiveEmployees();
		for (Employee e : employees) {
			EmployeeJsonDto temp = mapper.mapOne(e, EmployeeJsonDto.class);
			temp.setFullName(e.getFullName());
			dtos.add(temp);
		}
		return dtos;
	}

}
