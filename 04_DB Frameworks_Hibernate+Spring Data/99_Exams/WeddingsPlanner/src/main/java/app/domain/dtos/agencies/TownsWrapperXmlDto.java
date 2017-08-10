package app.domain.dtos.agencies;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsWrapperXmlDto {

	@XmlElement(name = "town")
	List<TownXmlDto> townDtos;

	public TownsWrapperXmlDto() {
		super();
	}

	public List<TownXmlDto> getTownDtos() {
		return townDtos;
	}

	public void setTownDtos(List<TownXmlDto> townDtos) {
		this.townDtos = townDtos;
	}
	
}
