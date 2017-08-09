package app.domain.dtos.workshops;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationWrapperDto {
	
	@XmlElement(name = "location")
	private List<LocationDto> locationDtos;

	public LocationWrapperDto() {
		super();
		this.locationDtos = new ArrayList<>();
	}

	public List<LocationDto> getLocationDtos() {
		return locationDtos;
	}

	public void setLocationDtos(List<LocationDto> locationDtos) {
		this.locationDtos = locationDtos;
	}
	
	public void addLocationDtos(LocationDto locationDto) {
		this.locationDtos.add(locationDto);
	}
	
}
