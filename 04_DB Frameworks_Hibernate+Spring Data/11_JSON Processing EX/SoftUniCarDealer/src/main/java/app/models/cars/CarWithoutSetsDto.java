package app.models.cars;

import com.google.gson.annotations.Expose;

public class CarWithoutSetsDto {
	
	@Expose
	private long id;
	
	@Expose
	private String make;
	
	@Expose
	private String model;
	
	@Expose
	private Long travelledDistance;

	public CarWithoutSetsDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
