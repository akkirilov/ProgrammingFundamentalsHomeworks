package app.models.cars;

import java.util.Set;

import com.google.gson.annotations.Expose;

import app.models.parts.PartWithoutQuantityDto;

public class CarWithPartsDto {

	@Expose
	private String make;
	
	@Expose
	private String model;
	
	@Expose
	private Long travelledDistance;
	
	@Expose
	private Set<PartWithoutQuantityDto> parts;

	public CarWithPartsDto() {
		super();
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

	public Set<PartWithoutQuantityDto> getParts() {
		return parts;
	}

	public void setParts(Set<PartWithoutQuantityDto> parts) {
		this.parts = parts;
	}
	
}
