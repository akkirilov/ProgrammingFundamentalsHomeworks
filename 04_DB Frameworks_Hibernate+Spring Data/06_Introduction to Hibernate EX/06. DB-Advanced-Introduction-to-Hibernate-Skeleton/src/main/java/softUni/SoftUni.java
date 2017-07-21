package softUni;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.mapping.Table;

import entities.Town;

public class SoftUni {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("softuni");
		EntityManager em = emf.createEntityManager();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello User!");
		
		while (true) {
			
			System.out.println();
			System.out.printf("2 = Create Objects, 3 = Remove Objects, 4 = Contains Employee, 5 = Data Refresh,%n"
					+ "6 = Employees with salary over than..., %n"
					+ "7a = Find employees by town, 7b = Find employees by department, %n"
					+ "8a = Add new Address, 8b = Update employee address, 8c = Find Top 10 addresses,%n"
					+ "8d = Find employee's projects, 8e = Find Employees By Time Interval of their projects %n"
					+ "8f = Find departments with employees more than...,%n"
					+ "9 = Try concurrent database changes, 10 - Find latest 10 projects,%n"
					+ "11 = Increase salaries in department ..., 12 = Remove Town,%n"
					+ "13 = Find employee which name starts with..., 14 = Max salaries in departmens  %n");
			System.out.println("31 = Add new town");
			
			String command = scanner.nextLine();
			if (command.equals("0")) {
				break;
			}
			
			switch (command) {
			case "2":
				Problem.addObjects(em);
				break;
			case "3":
				Problem.removeObjects(em);
				break;
			case "4":
				System.out.println("Enter name of the employee: ");
				String nameOfEmployeeToCheck = scanner.nextLine();
				Problem.isEmployeeExist(em, nameOfEmployeeToCheck);
				break;
			case "5":
				System.out.println("Enter id of the employee: ");
				Integer id = Integer.parseInt(scanner.nextLine());
				Problem.refreshEntityManager(em, id);
				break;
			case "6":
				System.out.println("Enter salary: ");
				BigDecimal enteredSalary = new BigDecimal(scanner.nextLine());
				Problem.findEmployeesWithSalaryOverEntered(em, enteredSalary);
				break;
			case "7a":
				System.out.println("Enter name of the town: ");
				String nameOfTown = scanner.nextLine();
				Problem.findEmployeesByTown(em, nameOfTown);				
			break;
			case "7b":
				System.out.println("Enter name of the department: ");
				String nameOfDepartment = scanner.nextLine();
				Problem.findEmployeesByDepartment(em, nameOfDepartment);				
			break;
			case "8a":
				System.out.println("Enter address: ");
				String addressToAdd = scanner.nextLine();
				System.out.println("Enter town: ");
				String fromTown = scanner.nextLine();
				Problem.addNewAddress(em, addressToAdd, fromTown);				
			break;
			case "8b":
				System.out.println("Enter employee id: ");
				Integer employeeId = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter address: ");
				String newAddressToAdd = scanner.nextLine();
				System.out.println("Enter town: ");
				String newTownToAdd = scanner.nextLine();
				Problem.updateEmployeeAddress(em, newAddressToAdd, newTownToAdd, employeeId);				
			break;
			case "8c":
				Problem.findTopTenAddresses(em);
				break;
			case "8d":
				System.out.println("Enter employee id: ");
				Integer employeeIdToFindProjects = Integer.parseInt(scanner.nextLine());
				Problem.findEmployeesProjectsById(em, employeeIdToFindProjects);
				break;
			case "8e":
				System.out.println("Enter start date");
				Integer startYear = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter end date");
				Integer endYear = Integer.parseInt(scanner.nextLine());
				Problem.findEmployeesWithProjectsByDateInterval(em, startYear, endYear);
				break;
			case "8f":
				System.out.println("Enter minimal count for department: ");
				Integer minCount= Integer.parseInt(scanner.nextLine());
				Problem.findDepartmentsByMinCountOfEmployees(em, minCount);
				break;
			case "9":
				Problem.tryConcurentChangesToDatabase();
				break;
			case "10":
				Problem.findLatestTenProjects(em);
				break;
			case "11":
				System.out.println("Enter name of the new department: ");
				String departmentName = scanner.nextLine();
				Problem.increaseSalaryInDepartment(em, departmentName);
			break;
			case "12":
				System.out.println("Enter name of the town: ");
				String townName = scanner.nextLine();
				Problem.removeTown(em, townName);
			break;
			case "13":
				System.out.println("Enter first name or first letters of employee: ");
				String employeeName = scanner.nextLine();
				Problem.findEnmployeeByFirstLetters(em, employeeName);
			break;
			case "14":
				Problem.findMaxSalariesForAllDepartments(em);
				break;
			
			case "31":
				System.out.println("Enter name of the town: ");
				String name = scanner.nextLine();
				Problem.addTown(em, name);
				
				System.out.println("Successfully add " + name);
			break;
				
			
			default:
				continue;
			}
			
		}
		
		em.close();
		scanner.close();
		emf.close();
		
	}
	
}
