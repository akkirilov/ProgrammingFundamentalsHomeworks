package app.domain.dtos.workshops;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participants")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantsWrapperXmlDto {
	
	@XmlAttribute(name = "count")
	private Integer count;

	@XmlElement(name = "participant")
	private List<ParticipantByLocation> participants;

	public ParticipantsWrapperXmlDto() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<ParticipantByLocation> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantByLocation> participants) {
		this.participants = participants;
	}
	

}
