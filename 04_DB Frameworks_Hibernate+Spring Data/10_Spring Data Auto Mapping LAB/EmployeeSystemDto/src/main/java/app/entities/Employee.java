package app.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Basic
	private BigDecimal salary;
	
	@Basic
	private Date birthday;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "managers_employees",
			joinColumns = @JoinColumn(name = "manager_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
	private Set<Employee> managedEmployees;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, BigDecimal salary, Date birthday, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.birthday = birthday;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getManagedEmployees() {
		return managedEmployees;
	}

	public void setManagedEmployees(Set<Employee> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
	public void addManagedEmployee(Employee managedEmployee) {
		if (this.managedEmployees == null) {
			this.managedEmployees = new HashSet<>();
		}
		this.managedEmployees.add(managedEmployee);
	}

	@Override
	public String toString() {
		return String.format("id: %d%n"
				+ "firstName: %s%n"
				+ "lastName: %s%n"
				+ "birthday: %s%n"
				+ "salary: %.2f%n"
				+ "Manager:%n"
				+ "- firstName: %s%n"
				+ "- lastName: %s%n"
				+ "Address:%n"
				+ "- address_id: %d%n"
				+ "- street: %s%n"
				+ "- City:%n"
				+ "-- city_id: %s%n"
				+ "-- name: %s%n", 
				id, firstName, lastName, birthday, salary, 
				manager != null ? manager.getFirstName() : "",
				manager != null ? manager.getLastName() : "", address.getId(),
				address.getStreet(), address.getCity().getId(), address.getCity().getName());
	}
	
}
