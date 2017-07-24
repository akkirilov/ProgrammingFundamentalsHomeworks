package model.motorVehicles.trains;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.motorVehicles.MotorVehicle;
import model.motorVehicles.trains.carriages.Carriage;

@Entity
@Table(name = "trains")
public class Train extends MotorVehicle{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "locomotive_id", referencedColumnName = "id")
	private Locomotive locomotive;
	
	@Column(name = "number_of_carriages")
	private Integer numberOfCarriages;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "trains_carriages", 
			joinColumns = @JoinColumn(name = "train_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "carriage_id", referencedColumnName = "id"))
	private Set<Carriage> carriages;

	public Train() {
		super();
	}

	public Train(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity,
			Locomotive locomotive, Set<Carriage> carriages) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
		this.locomotive = locomotive;
		this.carriages = carriages;
		this.numberOfCarriages = carriages.size();
	}

	public Locomotive getLocomotive() {
		return locomotive;
	}

	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}

	public Integer getNumberOfCarriages() {
		return numberOfCarriages;
	}

	public void setNumberOfCarriages(Integer numberOfCarriages) {
		this.numberOfCarriages = numberOfCarriages;
	}

	public Set<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(Set<Carriage> carriages) {
		this.carriages = carriages;
	}
	
}
