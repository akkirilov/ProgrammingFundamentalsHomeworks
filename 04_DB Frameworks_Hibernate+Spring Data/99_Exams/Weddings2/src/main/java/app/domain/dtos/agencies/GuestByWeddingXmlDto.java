package app.domain.dtos.agencies;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "guest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestByWeddingXmlDto implements Serializable {
	
	@XmlAttribute(name = "family")
	private String family;
	
	@XmlValue
	private String guest;

	public GuestByWeddingXmlDto() {
		super();
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getGuestFullName() {
		return guest;
	}

	public void setGuestFullName(String guestFullName) {
		this.guest = guestFullName;
	}
	
}
