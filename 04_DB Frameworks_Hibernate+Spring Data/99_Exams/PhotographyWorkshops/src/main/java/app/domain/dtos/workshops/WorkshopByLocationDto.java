package app.domain.dtos.workshops;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WorkshopByLocationDto {
	
	private String name;
	
	private BigDecimal totalProfit;
	
	private BigDecimal pricePerParticipant;
	
	private List<ParticipantDto> participants;
	
	private ParticipantsDto workshopParticipants;

	public WorkshopByLocationDto() {
		super();
	}

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "total-profit")
	public BigDecimal getTotalProfit() {
		BigDecimal sum = this.pricePerParticipant;
		sum = sum.multiply(BigDecimal.valueOf(participants.size()));
		sum = sum.subtract(sum.multiply(BigDecimal.valueOf(0.2)));
		return sum;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	@XmlTransient
	public BigDecimal getPricePerParticipant() {
		return pricePerParticipant;
	}

	public void setPricePerParticipant(BigDecimal pricePerParticipant) {
		this.pricePerParticipant = pricePerParticipant;
	}

	@XmlTransient
	public List<ParticipantDto> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDto> participants) {
		this.participants = participants;
	}

	@XmlElement(name = "participants")
	public ParticipantsDto getWorkshopParticipants() {
		return workshopParticipants;
	}

	public void setWorkshopParticipants(ParticipantsDto workshopParticipants) {
		this.workshopParticipants = workshopParticipants;
	}

	

	
	
}
