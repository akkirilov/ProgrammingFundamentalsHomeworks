package model.motorVehicles.planes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.motorVehicles.MotorVehicle;

@Entity
@Table(name = "planes")
public class Plane extends MotorVehicle{
	
	@Basic
	private String owner;
	
	@Basic
	private String color;
	
	@Column(name = "passengers_capacity")
	private Integer passengersCapacity;

	public Plane() {
		super();
	}

	public Plane(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity, 
			String owner, String color, Integer passengersCapacity) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
		this.owner = owner;
		this.color = color;
		this.passengersCapacity = passengersCapacity;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPassengersCapacity() {
		return passengersCapacity;
	}

	public void setPassengersCapacity(Integer passengersCapacity) {
		this.passengersCapacity = passengersCapacity;
	}

}
