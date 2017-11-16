package p02_CarShop.cars;

import java.io.Serializable;

public class Seat implements Car, Serializable {
	
	private static final long serialVersionUID = 728637100588442992L;
	
	private String model;
	private String color;
	private Integer horsePower;
	private String countryProduced;

	public Seat(String model, String color, Integer horsePower, String countryProduced) {
		super();
		this.model = model;
		this.color = color;
		this.horsePower = horsePower;
		this.countryProduced = countryProduced;
	}

	public String getCountryProduced() {
		return countryProduced;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public Integer getHorsePower() {
		return this.horsePower;
	}

	@Override
	public String toString() {
		return String.format("This is %s produced in %s and have %d tires",
				this.getModel(),
				this.getCountryProduced(),
				Car.TIRES);
	}

}
