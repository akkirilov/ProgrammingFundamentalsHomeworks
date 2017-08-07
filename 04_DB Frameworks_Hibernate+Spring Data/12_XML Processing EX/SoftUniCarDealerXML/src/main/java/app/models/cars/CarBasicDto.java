package app.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarBasicDto {

	@Expose
	@XmlElement(name = "make")
	private String make;
	
	@Expose
	@XmlElement(name = "model")
	private String model;
	
	@Expose
	@XmlElement(name = "travelled-distance")
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
