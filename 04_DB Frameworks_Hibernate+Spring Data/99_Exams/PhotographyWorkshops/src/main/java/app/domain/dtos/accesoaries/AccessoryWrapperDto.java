package app.domain.dtos.accesoaries;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryWrapperDto {

	@XmlElement(name = "accessory")
	private List<AccessoryImportXmlDto> accessoryImportXmlDto;

	public AccessoryWrapperDto() {
		super();
	}

	public List<AccessoryImportXmlDto> getAccessoryImportXmlDto() {
		return accessoryImportXmlDto;
	}

	public void setAccessoryImportXmlDto(List<AccessoryImportXmlDto> accessoryImportXmlDto) {
		this.accessoryImportXmlDto = accessoryImportXmlDto;
	}
	
}
