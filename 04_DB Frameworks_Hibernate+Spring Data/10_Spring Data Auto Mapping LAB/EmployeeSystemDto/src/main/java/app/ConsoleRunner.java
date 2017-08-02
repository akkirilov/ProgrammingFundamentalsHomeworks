package app;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.entities.Address;
import app.entities.City;
import app.entities.Employee;
import app.entities.EmployeeDto;
import app.entities.EmployeeNamesDto;
import app.entities.EmployeeNamesInterface;
import app.entities.EmployeeWithManagerDto;
import app.entities.ManagedEmployeeDto;
import app.entities.ManagerDto;
import app.services.api.EmployeeService;
import app.utils.dto.ConverterDTO;

@Component
public class ConsoleRunner implements CommandLineRunner{
	
	private SimpleDateFormat sdf = new SimpleDateFormat();
	
	private EmployeeService employeeService;
	
	@Autowired
	public ConsoleRunner(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Employee> employees;
		List<ManagerDto> managersDto;
		List<EmployeeWithManagerDto> employeeWithManagerDtos;
		String command;
		Long id;
		Employee employee;
		Employee employeeFromDto;
		EmployeeDto employeeDto;
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			printMenu();
			
			command = scanner.nextLine();
			if (command.equals("e")) {
				break;
			}
			
			switch (command) {
			case "0":
				initializeDatabase();
				break;
			case "1":
				System.out.println("Enter Employee Id:");
				id = Long.parseLong(scanner.nextLine());
				employee = employeeService.findById(id);
				
				System.out.println("Employee Data Before Convert:");
				System.out.println(employee.toString());
				
				employeeDto = ConverterDTO.convert(employee, EmployeeDto.class);
				System.out.println("EmployeeDto Data:");
				System.out.println(employeeDto.toString());
				
				employeeFromDto = ConverterDTO.convert(employeeDto, Employee.class);
				System.out.println("Employee Data From Dto:");
				System.out.println(employeeFromDto.toString());
				
				System.out.println("Try to save new employee, created from the Dto'? (y/n)");
				command = scanner.nextLine().toLowerCase();
				if (command.equals("y")) {
					employeeService.save(employeeFromDto);					
				}
				break;
			case "2":
				employees = employeeService.findAll();
				managersDto = new ArrayList<>();
				for (Employee tempEmployee : employees) {
					if (tempEmployee.getManagedEmployees() != null 
							&& tempEmployee.getManagedEmployees().size() > 0) {
						managersDto.add(ConverterDTO.convert(tempEmployee, ManagerDto.class));
					}
				}
				for (ManagerDto managerDto : managersDto) {
					System.out.print(managerDto);
					for (ManagedEmployeeDto managedEmployeeDto : managerDto.getManagedEmployees()) {
						System.out.print("    - " + managedEmployeeDto);
					}
				}
				break;
			case "3":
				employees = employeeService.findAll();
				employeeWithManagerDtos = ConverterDTO.convertToEmployeeWithManager(employees, EmployeeWithManagerDto.class);
				for (EmployeeWithManagerDto employeeWithManagerDto : employeeWithManagerDtos) {
					System.out.print(employeeWithManagerDto);
				}
				break;
			case "4":
				List<EmployeeNamesInterface> employeeNames = employeeService.findAllEmployeeNames();
				List<EmployeeNamesDto> employeeNamesDtos = ConverterDTO.convert(employeeNames, EmployeeNamesDto.class);
				for (EmployeeNamesDto e : employeeNamesDtos) {
					System.out.print(e);
				}
				break;
				
			default:
				break;
			}
		}
		scanner.close();		
		
	}
		
	private void printMenu() {
		
		System.out.println("e = Exit");
		System.out.println("0 = Initialize Database");
		System.out.println("1 = Create EmployeeDto From Employee and again in Employee (check data trace)");
		System.out.println("2 = Print ManagerDto and managed employeeDto list");
		System.out.println("3 = Print employeeWithManagerDto List");
		System.out.println("4 = Fetch names of employees and convert them in DTOs");
		
	}

	public void initializeDatabase() throws ParseException {
		
		sdf.applyPattern("dd MM yyyy");
		
		City city1 = new City("Sofia");
		City city2 = new City("Varna");
		City city3 = new City("Lom");
		
		Address address1 = new Address("1 Sofiiska Str.", city1);
		Address address2 = new Address("1 Varnenska Str.", city2);
		Address address3 = new Address("1 Lomska Str.", city3);
		Address address4 = new Address("2 Varnenska Str.", city2);
		Address address5 = new Address("2 Sofiiska Str.", city1);
		Address address6 = new Address("2 Lomska Str.", city3);
		
		Employee employee1 = new Employee("Gosho", "Goshansky", new BigDecimal("1024.24"), sdf.parse("01 01 1981"), address1);
		Employee employee2 = new Employee("Pesho", "Peshansky", new BigDecimal("500.24"), sdf.parse("11 02 1982"), address2);
		Employee employee3 = new Employee("Tosho", "Toshansky", new BigDecimal("300.24"), sdf.parse("21 03 1983"), address3);
		Employee employee4 = new Employee("Goshka", "Goshanska", new BigDecimal("1023.24"), sdf.parse("01 01 1984"), address1);
		Employee employee5 = new Employee("Pesha", "Peshanska", new BigDecimal("508.24"), sdf.parse("11 02 1985"), address2);
		Employee employee6 = new Employee("Rasho", "Rashovsky", new BigDecimal("558.74"), sdf.parse("11 02 1995"), address4);
		Employee employee7 = new Employee("Gesho", "Geshansky", new BigDecimal("548.24"), sdf.parse("11 02 1986"), address5);
		Employee employee8 = new Employee("Masha", "Mashanska", new BigDecimal("638.84"), sdf.parse("19 03 1985"), address6);
		Employee employee9 = new Employee("Chasha", "Chashanska", new BigDecimal("908.25"), sdf.parse("21 11 1996"), address6);
		Employee employee10 = new Employee("Vesha", "Geshanska", new BigDecimal("708.44"), sdf.parse("11 02 1985"), address5);
		
		employee2.setManager(employee1);
		employee3.setManager(employee1);
		employee4.setManager(employee2);
		employee5.setManager(employee2);
		employee6.setManager(employee3);
		employee7.setManager(employee4);
		employee8.setManager(employee2);
		employee9.setManager(employee2);
		employee10.setManager(employee1);
		
		Set<Employee> managedEmployees1 = new HashSet<>();
		
		managedEmployees1.add(employee2);
		managedEmployees1.add(employee3);
		managedEmployees1.add(employee10);
		employee1.setManagedEmployees(managedEmployees1);
		employee2.addManagedEmployee(employee4);
		employee2.addManagedEmployee(employee5);
		employee2.addManagedEmployee(employee8);
		employee2.addManagedEmployee(employee9);
		employee3.addManagedEmployee(employee6);
		employee4.addManagedEmployee(employee7);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		employees.add(employee8);
		employees.add(employee9);
		employees.add(employee10);
		
		employeeService.save(employees);
		
	}
    
}
