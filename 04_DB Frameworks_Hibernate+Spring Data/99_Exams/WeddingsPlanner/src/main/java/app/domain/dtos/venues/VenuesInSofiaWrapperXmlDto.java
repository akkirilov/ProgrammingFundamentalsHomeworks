package app.domain.dtos.venues;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import app.domain.entities.Wedding;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesInSofiaWrapperXmlDto {

	@XmlAttribute(name = "town")
	private String town = "Sofia";
	
	
	@XmlElement(name = "venue")
	List<VenueNameCapacityXmlDto> venueNameCapacityXmlDtos;

	public VenuesInSofiaWrapperXmlDto() {
		super();
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<VenueNameCapacityXmlDto> getVenueNameCapacityXmlDtos() {
		return venueNameCapacityXmlDtos;
	}

	public void setVenueNameCapacityXmlDtos(List<VenueNameCapacityXmlDto> venueNameCapacityXmlDtos) {
		this.venueNameCapacityXmlDtos = venueNameCapacityXmlDtos;
	}

}
