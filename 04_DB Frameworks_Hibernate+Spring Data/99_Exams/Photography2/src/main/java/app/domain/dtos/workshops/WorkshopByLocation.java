package app.domain.dtos.workshops;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WorkshopByLocation {

	private String name;
	
	private BigDecimal totalProfit;
	
	private ParticipantsWrapperXmlDto participantsWrapper;

	public WorkshopByLocation() {
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
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	@XmlElement(name = "participants")
	public ParticipantsWrapperXmlDto getParticipantsWrapper() {
		return participantsWrapper;
	}

	public void setParticipantsWrapper(ParticipantsWrapperXmlDto participantsWrapper) {
		this.participantsWrapper = participantsWrapper;
	}
	
}
