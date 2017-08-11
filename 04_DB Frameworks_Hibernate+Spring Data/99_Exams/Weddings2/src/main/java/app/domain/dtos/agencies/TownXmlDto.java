package app.domain.dtos.agencies;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownXmlDto implements Serializable  {

	@XmlAttribute(name = "name")
	private String name;
	
	@XmlElementWrapper(name = "agencies")
	@XmlElement(name = "agency")
	private List<AgencyByTownXmlDto> agencyByTownXmlDtos;

	public TownXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AgencyByTownXmlDto> getAgencyByTownXmlDtos() {
		return agencyByTownXmlDtos;
	}

	public void setAgencyByTownXmlDtos(List<AgencyByTownXmlDto> agencyByTownXmlDtos) {
		this.agencyByTownXmlDtos = agencyByTownXmlDtos;
	}
	
}
