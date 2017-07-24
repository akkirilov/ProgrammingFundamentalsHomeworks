package model.motorVehicles.ships;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CargoShip")
public class CargoShip extends Ship{
	
	@Column(name = "max_kilograms")
	private Integer maxKilograms;

	public CargoShip() {
		super();
	}

	public CargoShip(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity, String nationality, String captainName, Integer sizeOfCrew,
			Integer maxKilograms) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity, nationality, captainName,
				sizeOfCrew);
		this.maxKilograms = maxKilograms;
	}

	public Integer getMaxKilograms() {
		return maxKilograms;
	}

	public void setMaxKilograms(Integer maxKilograms) {
		this.maxKilograms = maxKilograms;
	}
	
}
