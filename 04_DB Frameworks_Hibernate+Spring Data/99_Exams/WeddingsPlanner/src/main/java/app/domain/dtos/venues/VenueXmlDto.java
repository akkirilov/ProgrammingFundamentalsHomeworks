package app.domain.dtos.venues;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenueXmlDto {

	@XmlAttribute(name = "name")
	private String name;

	@XmlElement(name = "capacity")
	private Integer capacity;

	@XmlElement(name = "town")
	private String town;

	public VenueXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
}
