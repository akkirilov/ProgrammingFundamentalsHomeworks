package model.nonMotorVehicles.bikes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.nonMotorVehicles.NonMotorVehicle;

@Entity
@Table(name = "bikes")
public class Bike extends NonMotorVehicle{
	
	@Column(name = "shifts_count")
	private Integer shiftsCount;
	
	@Basic
	private String color;

	public Bike() {
		super();
	}

	public Bike(String manufacturer, String model, Double price, Integer maxSpeed,
			Integer shiftsCount, String color) {
		super(manufacturer, model, price, maxSpeed);
		this.shiftsCount = shiftsCount;
		this.color = color;
	}

	public Integer getShiftsCount() {
		return shiftsCount;
	}

	public void setShiftsCount(Integer shiftsCount) {
		this.shiftsCount = shiftsCount;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
