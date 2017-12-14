package p03_employee_info.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import p03_employee_info.interfaces.Database;

public class EmployeeDatabase implements Database {

	@Override
    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40));

        return employees;
    }
}
