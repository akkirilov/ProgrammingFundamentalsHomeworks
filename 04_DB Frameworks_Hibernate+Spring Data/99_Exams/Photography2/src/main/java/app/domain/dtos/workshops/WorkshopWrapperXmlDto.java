package app.domain.dtos.workshops;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopWrapperXmlDto {

	@XmlElement(name = "workshop")
	private List<WorkshopXmlDto> workshopXmlDtos;
	
	@XmlElement(name = "location")
	private List<LocationXmlDto> workshopLocationDtos;

	public WorkshopWrapperXmlDto() {
		super();
	}

	public List<WorkshopXmlDto> getWorkshopXmlDtos() {
		return workshopXmlDtos;
	}

	public void setWorkshopXmlDtos(List<WorkshopXmlDto> workshopXmlDtos) {
		this.workshopXmlDtos = workshopXmlDtos;
	}

	public List<LocationXmlDto> getWorkshopLocationDtos() {
		return workshopLocationDtos;
	}

	public void setWorkshopLocationDtos(List<LocationXmlDto> workshopLocationDtos) {
		this.workshopLocationDtos = workshopLocationDtos;
	}
	
}
