package app.domain.dtos.presents;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import app.domain.enums.Size;

@XmlRootElement(name = "present")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentXmlDto implements Serializable {
	
	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "present-name")
	private String name;

	@XmlAttribute(name = "size")
	private Size size;

	@XmlAttribute(name = "amount")
	private BigDecimal cashAmount;
	
	@XmlAttribute(name = "invitation-id")
	private Long invitationId;

	public PresentXmlDto() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
}
