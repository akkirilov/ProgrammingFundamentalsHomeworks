package app.domain.dtos.presents;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.dtos.venues.VenueXmlDto;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentWrapperXmlDto implements Serializable {

	@XmlElement(name = "present")
	private List<PresentXmlDto> presentXmlDtos;

	public PresentWrapperXmlDto() {
		super();
	}

	public List<PresentXmlDto> getPresentXmlDtos() {
		return presentXmlDtos;
	}

	public void setPresentXmlDtos(List<PresentXmlDto> presentXmlDtos) {
		this.presentXmlDtos = presentXmlDtos;
	}

}
