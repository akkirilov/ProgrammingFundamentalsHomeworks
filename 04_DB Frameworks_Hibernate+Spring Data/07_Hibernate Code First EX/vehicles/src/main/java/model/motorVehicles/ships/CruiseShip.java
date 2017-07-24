package model.motorVehicles.ships;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CruiseShip")
public class CruiseShip extends Ship{
	
	@Column(name = "passengers_capacity")
	private Integer passengersCapacity;

	public CruiseShip() {
		super();
	}

	public CruiseShip(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity, String nationality, String captainName, Integer sizeOfCrew,
			Integer passengersCapacity) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity, nationality, captainName,
				sizeOfCrew);
		this.passengersCapacity = passengersCapacity;
	}

	public Integer getPassengersCapacity() {
		return passengersCapacity;
	}

	public void setPassengersCapacity(Integer passengersCapacity) {
		this.passengersCapacity = passengersCapacity;
	}

}
