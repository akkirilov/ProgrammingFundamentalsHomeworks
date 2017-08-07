package app.models.parts;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsDto {
	
	@XmlElement(name = "part")
	private List<PartBasicDto> partBasicDtos;

	public PartsDto() {
		super();
	}

	public List<PartBasicDto> getPartBasicDtos() {
		return partBasicDtos;
	}

	public void setPartBasicDtos(List<PartBasicDto> partBasicDtos) {
		this.partBasicDtos = partBasicDtos;
	}

}
