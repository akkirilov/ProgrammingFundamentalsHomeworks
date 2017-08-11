package app.domain.dtos.agencies;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsWrapperXmlDto implements Serializable {

	@XmlElement(name = "town")
	private List<TownXmlDto> townXmlDto;

	public TownsWrapperXmlDto() {
		super();
	}

	public List<TownXmlDto> getTownXmlDto() {
		return townXmlDto;
	}

	public void setTownXmlDto(List<TownXmlDto> townXmlDto) {
		this.townXmlDto = townXmlDto;
	}

}
