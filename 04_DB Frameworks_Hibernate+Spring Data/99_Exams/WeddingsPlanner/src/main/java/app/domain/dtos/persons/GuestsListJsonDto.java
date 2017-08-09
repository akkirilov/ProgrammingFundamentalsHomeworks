package app.domain.dtos.persons;

import java.util.List;

import com.google.gson.annotations.Expose;

import app.domain.dtos.agencies.AgencyBasicJsonDto;

public class GuestsListJsonDto {
	
	@Expose
	private String bride;

	@Expose
	private String brideroom;

	@Expose
	private AgencyBasicJsonDto agency;

	@Expose
	private Integer invitedGuests;

	@Expose
    private Integer brideGuests;

	@Expose
    private Integer bridegroomGuests;

	@Expose
    private Integer attendingGuests;

	@Expose
    private List<String> guests;

	public GuestsListJsonDto() {
		super();
	}

	public Integer getInvitedGuests() {
		return invitedGuests;
	}

	public void setInvitedGuests(Integer invitedGuests) {
		this.invitedGuests = invitedGuests;
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

	public Integer getAttendingGuests() {
		return attendingGuests;
	}

	public void setAttendingGuests(Integer attendingGuests) {
		this.attendingGuests = attendingGuests;
	}

	public List<String> getGuests() {
		return guests;
	}

	public void setGuests(List<String> guests) {
		this.guests = guests;
	}

	public String getBride() {
		return bride;
	}

	public void setBride(String bride) {
		this.bride = bride;
	}

	public String getBrideroom() {
		return brideroom;
	}

	public void setBrideroom(String brideroom) {
		this.brideroom = brideroom;
	}

	public AgencyBasicJsonDto getAgency() {
		return agency;
	}

	public void setAgency(AgencyBasicJsonDto agency) {
		this.agency = agency;
	}
	
}
