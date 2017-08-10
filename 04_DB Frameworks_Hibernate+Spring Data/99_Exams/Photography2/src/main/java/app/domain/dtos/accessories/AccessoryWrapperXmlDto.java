package app.domain.dtos.accessories;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryWrapperXmlDto {

	@XmlElement(name = "accessory")
	private List<AccessoryXmlDto> accessoryXmlDtos;

	public AccessoryWrapperXmlDto() {
		super();
	}

	public List<AccessoryXmlDto> getAccessoryXmlDtos() {
		return accessoryXmlDtos;
	}

	public void setAccessoryXmlDtos(List<AccessoryXmlDto> accessoryXmlDtos) {
		this.accessoryXmlDtos = accessoryXmlDtos;
	}
	
}
