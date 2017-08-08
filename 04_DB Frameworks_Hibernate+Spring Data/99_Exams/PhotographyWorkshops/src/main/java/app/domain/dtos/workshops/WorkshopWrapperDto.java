package app.domain.dtos.workshops;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopWrapperDto {
	
	@XmlElement(name = "workshop")
	private List<WorkshopImportXmlDto> workshopImportXmlDto;

	public WorkshopWrapperDto() {
		super();
	}

	public List<WorkshopImportXmlDto> getWorkshopImportXmlDto() {
		return workshopImportXmlDto;
	}

	public void setWorkshopImportXmlDto(List<WorkshopImportXmlDto> workshopImportXmlDto) {
		this.workshopImportXmlDto = workshopImportXmlDto;
	}

}
