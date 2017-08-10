package app.domain.dtos.workshops;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopLocationWrapperXmlDto {

	@XmlElement(name = "location")
	private List<LocationXmlDto> workshopLocationDtos;

	public WorkshopLocationWrapperXmlDto() {
		super();
	}

	public List<LocationXmlDto> getWorkshopLocationDtos() {
		return workshopLocationDtos;
	}

	public void setWorkshopLocationDtos(List<LocationXmlDto> workshopLocationDtos) {
		this.workshopLocationDtos = workshopLocationDtos;
	}
	
}
