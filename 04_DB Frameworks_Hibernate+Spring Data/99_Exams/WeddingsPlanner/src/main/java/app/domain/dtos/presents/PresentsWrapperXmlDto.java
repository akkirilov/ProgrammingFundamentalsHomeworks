package app.domain.dtos.presents;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentsWrapperXmlDto {
	
	@XmlElement(name = "present")
	private List<PresentXmlDto> presentXmlDtos;

	public PresentsWrapperXmlDto() {
		super();
	}

	public List<PresentXmlDto> getPresentXmlDtos() {
		return presentXmlDtos;
	}

	public void setPresentXmlDtos(List<PresentXmlDto> presentXmlDtos) {
		this.presentXmlDtos = presentXmlDtos;
	}

}
