package app.domain.dtos.venues;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import app.domain.entities.Wedding;

@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenueNameCapacityXmlDto {

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "capacity")
	private Integer capacity;
	
	@XmlElement(name = "weddings-count")
	private Integer weddingsCount;

	@XmlTransient
	List<Wedding> weddings;
	
	public VenueNameCapacityXmlDto() {
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

	public Integer getWeddingsCount() {
		return weddingsCount;
	}

	public void setWeddingsCount(Integer weddingsCount) {
		this.weddingsCount = weddingsCount;
	}

	public List<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(List<Wedding> weddings) {
		this.weddings = weddings;
	}
	
}
