package p03_employee_info.interfaces;

import java.util.List;

import p03_employee_info.models.Employee;

public interface InfoProvider {
	
	public List<Employee> getEmployeesByName();

    public Iterable<Employee> getEmployeesBySalary();
    
}
