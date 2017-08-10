package app.domain.dtos.workshops;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationXmlDto {

	@XmlAttribute(name = "name")
	private String name;
	
	@XmlElement(name = "workshop")
	private List<WorkshopByLocation> workshopByLocations;
	
	public LocationXmlDto() {
		super();
	}

	public List<WorkshopByLocation> getWorkshopByLocations() {
		return workshopByLocations;
	}

	public void setWorkshopByLocations(List<WorkshopByLocation> workshopByLocations) {
		this.workshopByLocations = workshopByLocations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
