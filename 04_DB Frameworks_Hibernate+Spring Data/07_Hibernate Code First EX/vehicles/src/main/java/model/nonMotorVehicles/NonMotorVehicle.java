package model.nonMotorVehicles;

import javax.persistence.Entity;
import javax.persistence.Table;

import model.Vehicle;

@Entity
@Table(name = "non_motor_vehicles")
public abstract class NonMotorVehicle extends Vehicle{

	public NonMotorVehicle() {
		super();
	}
	
	public NonMotorVehicle(String manufacturer, String model, Double price, Integer maxSpeed) {
		super(manufacturer, model, price, maxSpeed);
	}
	
}
