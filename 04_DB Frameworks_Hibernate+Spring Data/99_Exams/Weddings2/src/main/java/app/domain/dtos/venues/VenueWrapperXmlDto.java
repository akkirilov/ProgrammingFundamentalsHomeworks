package app.domain.dtos.venues;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenueWrapperXmlDto implements Serializable {

	@XmlElement(name = "venue")
	private List<VenueXmlDto> venueXmlDtos;

	public VenueWrapperXmlDto() {
		super();
	}

	public List<VenueXmlDto> getVenueXmlDtos() {
		return venueXmlDtos;
	}

	public void setVenueXmlDtos(List<VenueXmlDto> venueXmlDtos) {
		this.venueXmlDtos = venueXmlDtos;
	}

}
