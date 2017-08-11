package app.domain.dtos.weddings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.dtos.invitations.InvitationDto;

public class WeddingDto implements Serializable {
	
	@Expose
	@SerializedName(value = "Bride")
	private String bride;

	@Expose
	@SerializedName(value = "Bridegroom")
	private String bridegroom;

	@Expose
	@SerializedName(value = "Date")
	private String stringovaData;

	@Expose
	@SerializedName(value = "Agency")
	private String agencyName;

	@Expose
	@SerializedName(value = "Guests")
	private List<InvitationDto> invitations;
	
	public WeddingDto() {
		super();
	}

	public String getBride() {
		return bride;
	}

	public void setBride(String bride) {
		this.bride = bride;
	}

	public String getBridegroom() {
		return bridegroom;
	}

	public void setBridegroom(String bridegroom) {
		this.bridegroom = bridegroom;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public List<InvitationDto> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<InvitationDto> invitations) {
		this.invitations = invitations;
	}

	public String getStringovaData() {
		return stringovaData;
	}

	public void setStringovaData(String stringovaData) {
		this.stringovaData = stringovaData;
	}

}
