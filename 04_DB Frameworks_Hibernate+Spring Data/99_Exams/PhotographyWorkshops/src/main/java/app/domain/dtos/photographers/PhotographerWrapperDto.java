package app.domain.dtos.photographers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PhotographerWrapperDto {

	private List<PhotographersWithSameCamerasExportXmlDto> photographersWithSameCamerasExportXmlDtos;

	public PhotographerWrapperDto() {
		super();
	}

	@XmlElement(name = "photographer")
	public List<PhotographersWithSameCamerasExportXmlDto> getPhotographersWithSameCamerasExportXmlDtos() {
		return photographersWithSameCamerasExportXmlDtos;
	}

	public void setPhotographersWithSameCamerasExportXmlDtos(
			List<PhotographersWithSameCamerasExportXmlDto> photographersWithSameCamerasExportXmlDtos) {
		this.photographersWithSameCamerasExportXmlDtos = photographersWithSameCamerasExportXmlDtos;
	}

}
