package app.domain.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agencies")
public class Agency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	private String name;
	
	@Basic
	private Integer employeesCount;
	
	@Basic
	private String town;
	
	@OneToMany(mappedBy = "agency")
	private Set<Wedding> weddings;

	public Agency() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return employeesCount;
	}

	public void setCapacity(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Integer getEmployeesCount() {
		return employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}

	public Set<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(Set<Wedding> weddings) {
		this.weddings = weddings;
	}
	
}
