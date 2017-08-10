package app.domain.dtos.workshops;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopXmlDto {
	
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "start-date")
	private Date startDate;
	
	@XmlAttribute(name = "end-date")
	private Date endDate;

	@XmlAttribute(name = "location")
	private String location;

	@XmlAttribute(name = "price")
	private BigDecimal pricePerParticipant;
	
	@XmlElement(name = "trainer")
	private String trainerFullName;
	
	@XmlElementWrapper(name = "participants")
	@XmlElement(name = "participant")
	private Set<ParticipantXmlDto> participants;

	public WorkshopXmlDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getPricePerParticipant() {
		return pricePerParticipant;
	}

	public void setPricePerParticipant(BigDecimal pricePerParticipant) {
		this.pricePerParticipant = pricePerParticipant;
	}

	public String getTrainerFullName() {
		return trainerFullName;
	}

	public void setTrainerFullName(String trainerFullName) {
		this.trainerFullName = trainerFullName;
	}

	public Set<ParticipantXmlDto> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<ParticipantXmlDto> participants) {
		this.participants = participants;
	}
	
}
