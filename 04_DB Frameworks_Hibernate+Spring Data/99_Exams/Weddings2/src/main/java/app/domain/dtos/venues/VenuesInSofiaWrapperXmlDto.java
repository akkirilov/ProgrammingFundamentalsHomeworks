package app.domain.dtos.venues;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesInSofiaWrapperXmlDto implements Serializable {

	@XmlAttribute(name = "town")
	private String town;
	
	@XmlElement(name = "venue")
	private List<VenueinSofiaXmlDto> venueXmlDtos;

	public VenuesInSofiaWrapperXmlDto() {
		super();
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<VenueinSofiaXmlDto> getVenueXmlDtos() {
		return venueXmlDtos;
	}

	public void setVenueXmlDtos(List<VenueinSofiaXmlDto> venueXmlDtos) {
		this.venueXmlDtos = venueXmlDtos;
	}

}
