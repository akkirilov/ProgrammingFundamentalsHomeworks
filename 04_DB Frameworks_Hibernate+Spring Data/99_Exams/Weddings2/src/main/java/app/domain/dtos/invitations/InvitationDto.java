package app.domain.dtos.invitations;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.enums.Family;

public class InvitationDto implements Serializable {

	@Expose
	@SerializedName(value = "Name")
	private String fullName;

	@Expose
	@SerializedName(value = "RSVP")
	private Boolean attending;

	@Expose
	@SerializedName(value = "Family")
	private Family family;

	public InvitationDto() {
		super();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
