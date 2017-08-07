package app.models.cars;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import app.models.parts.PartWithoutQuantityDto;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsDto {

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
	@XmlElementWrapper(name = "parts")
	@XmlElement(name = "part")
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
