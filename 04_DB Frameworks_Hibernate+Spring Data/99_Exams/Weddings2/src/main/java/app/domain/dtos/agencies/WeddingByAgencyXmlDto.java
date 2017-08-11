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

import app.domain.entities.Invitation;

@XmlRootElement(name = "wedding")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WeddingByAgencyXmlDto implements Serializable {
	
	private BigDecimal cash;
	
	private Integer giftsCount;
	
	private String brideFullName;
	
	private String bridegroomFullName;
	
	private List<GuestByWeddingXmlDto> guestByWeddingXmlDtos;
	
	private List<Invitation> invitations;

	@XmlAttribute(name = "cash")
	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	@XmlAttribute(name = "presents")
	public Integer getGiftsCount() {
		return giftsCount;
	}

	public void setGiftsCount(Integer giftsCount) {
		this.giftsCount = giftsCount;
	}

	@XmlElement(name = "bride")
	public String getBrideFullName() {
		return brideFullName;
	}

	public void setBrideFullName(String brideFullName) {
		this.brideFullName = brideFullName;
	}

	@XmlElement(name = "bridegroom")
	public String getBridegroomFullName() {
		return bridegroomFullName;
	}

	public void setBridegroomFullName(String bridegroomFullName) {
		this.bridegroomFullName = bridegroomFullName;
	}

	@XmlElementWrapper(name = "guests")
	@XmlElement(name = "guest")
	public List<GuestByWeddingXmlDto> getGuestByWeddingXmlDtos() {
		return guestByWeddingXmlDtos;
	}

	public void setGuestByWeddingXmlDtos(List<GuestByWeddingXmlDto> guestByWeddingXmlDtos) {
		this.guestByWeddingXmlDtos = guestByWeddingXmlDtos;
	}

	@XmlTransient
	public List<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}
	
}
