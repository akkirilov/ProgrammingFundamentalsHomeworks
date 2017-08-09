package app.domain.dtos.workshops;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ParticipantsDto {
	
	private Integer count;
	
	private List<ParticipantDto> participants;
	

	public ParticipantsDto() {
		super();
		this.participants = new ArrayList<>();
	}

	@XmlElement(name = "participant")
	public List<ParticipantDto> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDto> participants) {
		this.participants = participants;
	}

	@XmlAttribute(name = "count")
	public Integer getCount() {
		return participants.size();
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
