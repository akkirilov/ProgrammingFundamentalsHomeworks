package app.models.cars;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsDto {
	
	@XmlElement(name = "car")
	private List<CarBasicDto> carBasicDtos;
	
	@XmlElement(name = "car")
	private List<CarWithoutSetsDto> carWithoutSetsDtos;
	
	@XmlElement(name = "car")
	private List<CarWithPartsDto> carWithPartsDtos;

	public CarsDto() {
		super();
	}

	public List<CarBasicDto> getCarBasicDtos() {
		return carBasicDtos;
	}

	public void setCarBasicDtos(List<CarBasicDto> carBasicDtos) {
		this.carBasicDtos = carBasicDtos;
	}

	public List<CarWithoutSetsDto> getCarWithoutSetsDtos() {
		return carWithoutSetsDtos;
	}

	public void setCarWithoutSetsDtos(List<CarWithoutSetsDto> carWithoutSetsDtos) {
		this.carWithoutSetsDtos = carWithoutSetsDtos;
	}

	public List<CarWithPartsDto> getCarWithPartsDtos() {
		return carWithPartsDtos;
	}

	public void setCarWithPartsDtos(List<CarWithPartsDto> carWithPartsDtos) {
		this.carWithPartsDtos = carWithPartsDtos;
	}

}
