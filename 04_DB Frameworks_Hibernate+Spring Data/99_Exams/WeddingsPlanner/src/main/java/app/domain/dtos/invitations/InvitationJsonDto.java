package app.domain.dtos.invitations;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.enums.Family;

public class InvitationJsonDto {
	
	@Expose
	@SerializedName("Name")
	private String name;
	
	@Expose
	@SerializedName("RSVP")
	private Boolean rsvp;
	
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

	public Boolean getRsvp() {
		return rsvp;
	}

	public void setRsvp(Boolean rsvp) {
		this.rsvp = rsvp;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
	
}
