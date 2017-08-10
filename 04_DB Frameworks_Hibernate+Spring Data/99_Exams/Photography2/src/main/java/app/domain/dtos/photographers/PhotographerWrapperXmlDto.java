package app.domain.dtos.photographers;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerWrapperXmlDto {

	@XmlElement(name = "photographer")
	private List<PhotographerWithSameCamera> photographerWithSameCameras;

	public PhotographerWrapperXmlDto() {
		super();
	}

	public List<PhotographerWithSameCamera> getPhotographerWithSameCameras() {
		return photographerWithSameCameras;
	}

	public void setPhotographerWithSameCameras(List<PhotographerWithSameCamera> photographerWithSameCameras) {
		this.photographerWithSameCameras = photographerWithSameCameras;
	}
	
}
