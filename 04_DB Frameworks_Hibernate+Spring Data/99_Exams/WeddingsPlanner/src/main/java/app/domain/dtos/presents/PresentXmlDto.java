package app.domain.dtos.presents;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.entities.Person;
import app.domain.enums.Size;

@XmlRootElement(name = "present")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentXmlDto {
	
	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "amount")
	private BigDecimal cashAmount;

	@XmlAttribute(name = "invitation-id")
	private Long invitationId;

	@XmlAttribute(name = "present-name")
	private String name;

	@XmlAttribute(name = "size")
	private Size size;

	public PresentXmlDto() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public Long getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
}
