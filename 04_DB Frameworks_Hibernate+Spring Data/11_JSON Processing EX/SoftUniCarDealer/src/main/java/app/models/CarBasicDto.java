package app.models;

import com.google.gson.annotations.Expose;

public class CarBasicDto {

	@Expose
	private String make;
	
	@Expose
	private String model;
	
	@Expose
	private Long travelledDistance;

	public CarBasicDto() {
		super();
	}

	public CarBasicDto(String make, String model, Long travelledDistance) {
		super();
		this.make = make;
		this.model = model;
		this.travelledDistance = travelledDistance;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getTravelledDistance() {
		return travelledDistance;
	}

	public void setTravelledDistance(Long travelledDistance) {
		this.travelledDistance = travelledDistance;
	}
		
}
