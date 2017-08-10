package app.domain.dtos.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accessory")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryXmlDto {
	
	@XmlAttribute(name = "name")
	private String name;

	public AccessoryXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
