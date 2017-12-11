package p04_DetailPrinter;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		
		Employee employeeBase = new EmployeeBase("Pesho");
		
		List<String> documents = new ArrayList<>();
		Employee manager = new Manager("Gosho", documents);
		Collections.addAll(documents, "Document 1", "Document 2", "Document 3", "Document 4", "Document 5");
		
		Collections.addAll(employees, employeeBase, manager);
		
		DetailsPrinter detailsPrinter = new DetailsPrinter(employees);
		detailsPrinter.printDetails();
		
	}

}
