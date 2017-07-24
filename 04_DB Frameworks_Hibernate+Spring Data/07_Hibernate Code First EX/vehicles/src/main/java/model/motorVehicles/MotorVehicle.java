package model.motorVehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.Vehicle;

@Entity
@Table(name = "motor_vehicles")
public abstract class MotorVehicle extends Vehicle {
	
	@Column(name = "number_of_engine")
	private String numberOfEngine;
	
	@Column(name = "engine_type")
	private String engineType;
	
	@Column(name = "tank_capacity")
	private Integer tankCapacity;

	public MotorVehicle() {
		super();
	}

	public MotorVehicle(String manufacturer, String model, Double price, Integer maxSpeed, 
			String numberOfEngine, String engineType, Integer tankCapacity) {
		super(manufacturer, model, price, maxSpeed);
		this.numberOfEngine = numberOfEngine;
		this.engineType = engineType;
		this.tankCapacity = tankCapacity;
	}

	public String getNumberOfEngine() {
		return numberOfEngine;
	}

	public void setNumberOfEngine(String numberOfEngine) {
		this.numberOfEngine = numberOfEngine;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public Integer getTankCapacity() {
		return tankCapacity;
	}

	public void setTankCapacity(Integer tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	
}
