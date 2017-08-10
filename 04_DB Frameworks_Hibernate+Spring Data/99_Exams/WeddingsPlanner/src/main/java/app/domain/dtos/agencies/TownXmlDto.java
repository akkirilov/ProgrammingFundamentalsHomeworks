package app.domain.dtos.agencies;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownXmlDto {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlElementWrapper(name = "agencies")
	@XmlElement(name = "agency")
	List<AgenciesByTownXmlDto> agenciesByTownXmlDtos;

	public TownXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AgenciesByTownXmlDto> getAgenciesByTownXmlDtos() {
		return agenciesByTownXmlDtos;
	}

	public void setAgenciesByTownXmlDtos(List<AgenciesByTownXmlDto> agenciesByTownXmlDtos) {
		this.agenciesByTownXmlDtos = agenciesByTownXmlDtos;
	}

}
