package app.domain.dtos.weddings;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.dtos.agencies.AgencyBasicJsonDto;
import app.domain.entities.Agency;
import app.domain.entities.Invitation;
import app.domain.entities.Person;
import app.domain.enums.Gender;

public class WeddingBasicJsonDto {

	@Expose
	private String brideFullName;
	
	@Expose
	private String bridegroomFullName;
	
	Set<Invitation> invitations;
	
	private List<String> guests;
	
	private AgencyBasicJsonDto agency;

	public WeddingBasicJsonDto() {
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

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}

	public List<String> getGuests() {
		return guests;
	}

	public void setGuests(List<String> guests) {
		this.guests = guests;
	}

	public AgencyBasicJsonDto getAgency() {
		return agency;
	}

	public void setAgency(AgencyBasicJsonDto agency) {
		this.agency = agency;
	}

}
