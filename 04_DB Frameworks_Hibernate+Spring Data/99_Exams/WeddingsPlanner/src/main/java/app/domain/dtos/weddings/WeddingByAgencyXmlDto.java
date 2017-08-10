package app.domain.dtos.weddings;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.dtos.persons.GuestByWeddingByAgencyXmlDto;

@XmlRootElement(name = "wedding")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeddingByAgencyXmlDto {
	
	@XmlAttribute(name = "cash")
	private BigDecimal cash;
	
	@XmlAttribute(name = "presents")
	private Integer presents;
	
	@XmlElement(name = "bride")
	private String brideFullName;
	
	@XmlElement(name = "bridegroom")
	private String bridegroomFullName;
	
	
	@XmlElementWrapper(name = "guests")
	@XmlElement(name = "guest")
	List<GuestByWeddingByAgencyXmlDto> guests;


	public WeddingByAgencyXmlDto() {
		super();
	}


	public String getBrideFullName() {
		return brideFullName;
	}


	public void setBrideFullName(String brideFullName) {
		this.brideFullName = brideFullName;
	}


	public String getBridegroomFullName() {
		return bridegroomFullName;
	}


	public void setBridegroomFullName(String bridegroomFullName) {
		this.bridegroomFullName = bridegroomFullName;
	}


	public List<GuestByWeddingByAgencyXmlDto> getGuestByWeddingByAgencyXmlDtos() {
		return guests;
	}


	public void setGuestByWeddingByAgencyXmlDtos(List<GuestByWeddingByAgencyXmlDto> guests) {
		this.guests = guests;
	}


	public BigDecimal getCash() {
		return cash;
	}


	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}


	public Integer getPresents() {
		return presents;
	}


	public void setPresents(Integer presents) {
		this.presents = presents;
	}


	public List<GuestByWeddingByAgencyXmlDto> getGuests() {
		return guests;
	}


	public void setGuests(List<GuestByWeddingByAgencyXmlDto> guests) {
		this.guests = guests;
	}

}
