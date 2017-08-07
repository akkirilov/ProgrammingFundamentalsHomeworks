package app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "travelled_distance")
	private Long travelledDistance;
	
	@ManyToMany()
	@JoinTable(name = "parts_cars",
			joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
	private Set<Part> parts;
	
	@OneToMany(mappedBy = "car")
	private Set<Sale> sales;

	public Car() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getTravelledDistance() {
		return travelledDistance;
	}

	public void setTravelledDistance(Long travelledDistance) {
		this.travelledDistance = travelledDistance;
	}

	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	
}
