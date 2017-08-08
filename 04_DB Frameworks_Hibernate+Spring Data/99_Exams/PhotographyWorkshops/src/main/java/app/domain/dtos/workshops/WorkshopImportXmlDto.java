package app.domain.dtos.workshops;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopImportXmlDto {
	
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
	private String trainerName;
	
	@XmlElementWrapper(name = "participants")
	@XmlElement(name = "participant")
	private List<ParticipantImportXmlDto> participantImportXmlDto;

	public WorkshopImportXmlDto() {
		super();
		this.participantImportXmlDto = new ArrayList<>();
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

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public List<ParticipantImportXmlDto> getParticipantImportXmlDto() {
		return participantImportXmlDto;
	}

	public void setParticipantImportXmlDto(List<ParticipantImportXmlDto> participantImportXmlDto) {
		this.participantImportXmlDto = participantImportXmlDto;
	}

}
