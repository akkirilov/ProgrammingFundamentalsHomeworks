package model.motorVehicles.cars;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.motorVehicles.MotorVehicle;

@Entity
@Table(name = "cars")
public class Car extends MotorVehicle{
	
	@Column(name = "number_of_doors")
	private Integer numberOfDoors;
	
	@Column(name = "has_insurance")
	private boolean hasInsurance;

	public Car() {
		super();
	}

	public Car(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity,
			Integer numberOfDoors, boolean hasInsurance) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
		this.numberOfDoors = numberOfDoors;
		this.hasInsurance = hasInsurance;		
	}

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public boolean isHasInsurance() {
		return hasInsurance;
	}

	public void setHasInsurance(boolean hasInsurance) {
		this.hasInsurance = hasInsurance;
	}

}
