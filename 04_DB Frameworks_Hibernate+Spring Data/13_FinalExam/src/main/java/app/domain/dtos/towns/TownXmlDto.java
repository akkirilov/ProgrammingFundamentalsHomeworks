package app.domain.dtos.towns;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownXmlDto implements Serializable {

	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "population")
	private Long population;
	
	@XmlAttribute(name = "town_clients")
	private Long townClients;

	public TownXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Long getTownClients() {
		return townClients;
	}

	public void setTownClients(Long townClients) {
		this.townClients = townClients;
	}
	
}
