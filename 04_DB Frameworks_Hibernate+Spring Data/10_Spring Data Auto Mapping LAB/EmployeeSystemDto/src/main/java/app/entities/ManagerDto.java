package app.entities;

import java.util.HashSet;
import java.util.Set;

public class ManagerDto {

	private String firstName;

	private String lastName;

	private Set<ManagedEmployeeDto> managedEmployees;

	public ManagerDto() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<ManagedEmployeeDto> getManagedEmployees() {
		return managedEmployees;
	}

	public void setManagedEmployees(Set<ManagedEmployeeDto> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
	public void addManagedEmployees(ManagedEmployeeDto managedEmployee) {
		if (this.managedEmployees == null) {
			this.managedEmployees = new HashSet<>();
		}
		this.managedEmployees.add(managedEmployee);
	}

	@Override
	public String toString() {
		return String.format("%s %s | Employees: %d%n",
				firstName, lastName, managedEmployees.size());
	}
	
}
