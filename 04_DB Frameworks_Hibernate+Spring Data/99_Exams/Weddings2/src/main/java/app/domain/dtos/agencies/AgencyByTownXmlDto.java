package app.domain.dtos.agencies;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import app.domain.entities.Wedding;

@XmlRootElement(name = "agency")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AgencyByTownXmlDto implements Serializable {
	
	private String name;
	
	private BigDecimal profit;
		
	private List<Wedding> weddings;
	
	private List<WeddingByAgencyXmlDto> weddingsByAgencies;

	public AgencyByTownXmlDto() {
		super();
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "profit")
	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	@XmlTransient
	public List<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(List<Wedding> weddings) {
		this.weddings = weddings;
	}

	//@XmlElementWrapper(name = "wedding")
	@XmlElement(name = "wedding")
	public List<WeddingByAgencyXmlDto> getWeddingsByAgencies() {
		return weddingsByAgencies;
	}

	public void setWeddingsByAgencies(List<WeddingByAgencyXmlDto> weddingsByAgencies) {
		this.weddingsByAgencies = weddingsByAgencies;
	}
		
}
