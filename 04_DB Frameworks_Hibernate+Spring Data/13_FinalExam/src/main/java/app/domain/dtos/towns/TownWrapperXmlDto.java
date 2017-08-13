package app.domain.dtos.towns;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownWrapperXmlDto implements Serializable {

	@XmlElement(name = "town")
	private List<TownXmlDto> townXmlDtos;

	public TownWrapperXmlDto() {
		super();
	}

	public List<TownXmlDto> getTownXmlDtos() {
		return townXmlDtos;
	}

	public void setTownXmlDtos(List<TownXmlDto> townXmlDtos) {
		this.townXmlDtos = townXmlDtos;
	}
	
}
