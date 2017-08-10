package app.domain.dtos.agencies;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.dtos.weddings.WeddingByAgencyXmlDto;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgenciesByTownXmlDto {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "profit")
	private BigDecimal profit;
	
	@XmlElement(name = "wedding")
	List<WeddingByAgencyXmlDto> weddings;

	public AgenciesByTownXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public List<WeddingByAgencyXmlDto> getWeddings() {
		return weddings;
	}

	public void setWeddings(List<WeddingByAgencyXmlDto> weddingByAgencyXmlDtos) {
		this.weddings = weddingByAgencyXmlDtos;
	}
	
}
