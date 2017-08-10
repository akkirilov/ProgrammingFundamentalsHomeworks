package app.domain.dtos.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantXmlDto {
	
	@XmlAttribute(name = "first-name")
	private String firstName;
	
	@XmlAttribute(name = "last-name")
	private String lastName;

	public ParticipantXmlDto() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

}
