package app.models.cars;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;

import app.entities.Part;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarBasicAttributeDto {

	@Expose
	@XmlAttribute(name = "make")
	private String make;
	
	@Expose
	@XmlAttribute(name = "model")
	private String model;
	
	@Expose
	@XmlAttribute(name = "travelled-distance")
	private Long travelledDistance;
	
	@Expose
	@XmlTransient
	private Set<Part> parts;

	public CarBasicAttributeDto() {
		super();
	}

	public CarBasicAttributeDto(String make, String model, Long travelledDistance) {
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

	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}
		
}
