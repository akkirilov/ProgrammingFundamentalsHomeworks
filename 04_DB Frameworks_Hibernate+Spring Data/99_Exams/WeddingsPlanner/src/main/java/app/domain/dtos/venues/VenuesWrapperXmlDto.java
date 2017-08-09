package app.domain.dtos.venues;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesWrapperXmlDto {

	@XmlElement(name = "venue")
	List<VenueXmlDto> venueXmlDtos;

	public VenuesWrapperXmlDto() {
		super();
	}

	public List<VenueXmlDto> getVenueXmlDtos() {
		return venueXmlDtos;
	}

	public void setVenueXmlDtos(List<VenueXmlDto> venueXmlDtos) {
		this.venueXmlDtos = venueXmlDtos;
	}
	
}
