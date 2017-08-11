package app.domain.dtos.weddings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

import app.domain.dtos.agencies.AgencyByWeddingExportJsonDto;
import app.domain.dtos.invitations.InvitationDto;
import app.domain.entities.Invitation;

public class WeddingExportJsonDto implements Serializable { 
	
	@Expose
	private String brideFullName;

	@Expose
	private String bridegroomFullName;

	@Expose
	private AgencyByWeddingExportJsonDto agency;
	
	private Set<Invitation> invitations;
	
	@Expose
	@SerializedName(value = "invitedGuests")
	private Integer totalGuests;
	
	@Expose
	private Integer brideGuests;
	
	@Expose
	private Integer bridegroomGuests;

	@Expose
	private Integer attendingGuests;

	@Expose
	private List<String> guestList;

	public WeddingExportJsonDto() {
		super();
	}

	public String getBrideFullName() {
		return brideFullName;
	}

	public void setBrideFullName(String brideFullName) {
		this.brideFullName = brideFullName;
	}

	public String getBridegroomFullName() {
		return bridegroomFullName;
	}

	public void setBridegroomFullName(String bridegroomFullName) {
		this.bridegroomFullName = bridegroomFullName;
	}

	public AgencyByWeddingExportJsonDto getAgency() {
		return agency;
	}

	public void setAgency(AgencyByWeddingExportJsonDto agency) {
		this.agency = agency;
	}

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	public Integer getAttendingGuests() {
		return attendingGuests;
	}

	public void setAttendingGuests(Integer attendingGuests) {
		this.attendingGuests = attendingGuests;
	}

	public Integer getTotalGuests() {
		return totalGuests;
	}

	public void setTotalGuests(Integer totalGuests) {
		this.totalGuests = totalGuests;
	}

	public Integer getBrideGuests() {
		return brideGuests;
	}

	public void setBrideGuests(Integer brideGuests) {
		this.brideGuests = brideGuests;
	}

	public Integer getBridegroomGuests() {
		return bridegroomGuests;
	}

	public void setBridegroomGuests(Integer bridegroomGuests) {
		this.bridegroomGuests = bridegroomGuests;
	}

	public List<String> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<String> guestList) {
		this.guestList = guestList;
	}

}
