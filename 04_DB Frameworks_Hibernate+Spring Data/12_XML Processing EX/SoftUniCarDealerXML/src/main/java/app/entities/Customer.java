package app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Expose
	@Column(name = "name")
	private String name;
	
	@Expose
	@Column(name = "birth_date")
	private String birthDate;
	
	@Expose
	@Column(name = "is_young_driver")
	private Boolean isYoungDriver;
	

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private Set<Sale> sales;

	public Customer() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getIsYoungDriver() {
		return isYoungDriver;
	}

	public void setIsYoungDriver(Boolean isYoungDriver) {
		this.isYoungDriver = isYoungDriver;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	
}
