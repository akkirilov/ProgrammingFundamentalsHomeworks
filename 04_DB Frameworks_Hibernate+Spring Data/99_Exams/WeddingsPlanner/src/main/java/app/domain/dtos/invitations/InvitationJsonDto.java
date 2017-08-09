package app.domain.dtos.invitations;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.entities.Person;
import app.domain.enums.Family;

public class InvitationJsonDto implements Serializable {
	
	@Expose
	@SerializedName("Name")
	private String name;
	
	@Expose
	@SerializedName("RSVP")
	private Boolean attending;
	
	@Expose
	@SerializedName("Family")
	private Family family;

	public InvitationJsonDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAttending() {
		return attending;
	}

	public void setAttending(Boolean attending) {
		this.attending = attending;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
	
}
