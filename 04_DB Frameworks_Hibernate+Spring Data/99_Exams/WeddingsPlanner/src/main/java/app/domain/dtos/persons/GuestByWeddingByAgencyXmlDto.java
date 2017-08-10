package app.domain.dtos.persons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.enums.Family;

@XmlRootElement(name = "guest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestByWeddingByAgencyXmlDto {
	
	@XmlAttribute(name = "family")
	private Family family;
	
	@XmlAttribute(name = "fullName")
	private String guestFullName;

	public GuestByWeddingByAgencyXmlDto() {
		super();
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getGuestFullName() {
		return guestFullName;
	}

	public void setGuestFullName(String guestFullName) {
		this.guestFullName = guestFullName;
	}
	
}
