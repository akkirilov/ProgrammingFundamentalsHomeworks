package model.motorVehicles.trains.carriages;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PassengerCarriage")
public class PassengerCarriage extends Carriage{
	
	@Column(name = "standing_passengers")
	private Integer standingPassengers;

	public PassengerCarriage() {
		super();
	}

	public PassengerCarriage(Integer seatsCapacity, Integer standingPassengers) {
		super(seatsCapacity);
		this.standingPassengers = standingPassengers;
	}

	public Integer getStandingPassengers() {
		return standingPassengers;
	}

	public void setStandingPassengers(Integer standingPassengers) {
		this.standingPassengers = standingPassengers;
	}

}
