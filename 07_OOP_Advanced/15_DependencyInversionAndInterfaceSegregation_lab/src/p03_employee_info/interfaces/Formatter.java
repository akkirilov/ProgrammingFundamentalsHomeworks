package p03_employee_info.interfaces;

import p03_employee_info.models.Employee;

public interface Formatter {

	String format(Iterable<Employee> employees);
	
}
