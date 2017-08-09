package app.domain.dtos.weddings;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.dtos.invitations.InvitationJsonDto;
import app.domain.entities.Person;

public class WeddingJsonDto implements Serializable {

	@Expose
	@SerializedName("Bride")
	private String bride;

	@Expose
	@SerializedName("Bridegroom")
	private String bridegroom;

	@Expose
	@SerializedName("Date")
	private String date;

	@Expose
	@SerializedName("Agency")
	private String agency;
	
	@Expose
	@SerializedName("Guests")
	private Set<InvitationJsonDto> guests;

	public WeddingJsonDto() {
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

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Set<InvitationJsonDto> getGuests() {
		return guests;
	}

	public void setGuests(Set<InvitationJsonDto> guests) {
		this.guests = guests;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
