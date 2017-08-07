package app.models.cars;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithoutSetsDto {
	
	@Expose
	@XmlAttribute(name = "id")
	private long id;
	
	@Expose
	@XmlAttribute(name = "make")
	private String make;
	
	@Expose
	@XmlAttribute(name = "model")
	private String model;
	
	@Expose
	@XmlAttribute(name = "travelled-distance")
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
