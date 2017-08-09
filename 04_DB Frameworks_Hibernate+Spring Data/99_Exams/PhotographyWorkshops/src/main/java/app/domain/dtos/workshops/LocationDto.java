package app.domain.dtos.workshops;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationDto {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlElement(name = "workshop")
	private List<WorkshopByLocationDto> workshopByLocationDtos;

	public LocationDto() {
		super();
		this.workshopByLocationDtos = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkshopByLocationDto> getWorkshopByLocationDtos() {
		return workshopByLocationDtos;
	}

	public void setWorkshopByLocationDtos(List<WorkshopByLocationDto> workshopByLocationDtos) {
		this.workshopByLocationDtos = workshopByLocationDtos;
	}
	
	public void addWorkshopByLocationDtos(WorkshopByLocationDto workshopByLocationDto) {
		this.workshopByLocationDtos.add(workshopByLocationDto);
	}
	
}
