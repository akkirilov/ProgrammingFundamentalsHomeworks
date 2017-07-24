package model.motorVehicles.ships;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import model.motorVehicles.MotorVehicle;

@Entity
@Table(name = "ships")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Ship extends MotorVehicle{
	
	@Basic
	private String nationality;
	
	@Column(name ="captain_name")
	private String captainName;
	
	@Column(name = "size_of_crew")
	private Integer sizeOfCrew;

	public Ship() {
		super();
	}

	public Ship(String manufacturer, String model, Double price, Integer maxSpeed, String numberOfEngine,
			String engineType, Integer tankCapacity, 
			String nationality, String captainName, Integer sizeOfCrew) {
		super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity);
		this.nationality = nationality;
		this.captainName = captainName;
		this.sizeOfCrew = sizeOfCrew;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public Integer getSizeOfCrew() {
		return sizeOfCrew;
	}

	public void setSizeOfCrew(Integer sizeOfCrew) {
		this.sizeOfCrew = sizeOfCrew;
	}
	
}
