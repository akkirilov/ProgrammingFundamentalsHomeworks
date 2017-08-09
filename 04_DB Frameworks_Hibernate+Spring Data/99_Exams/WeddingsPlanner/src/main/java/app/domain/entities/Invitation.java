package app.domain.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import app.domain.enums.Family;

@Entity
@Table(name = "invitations")
public class Invitation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "wedding")
	private Wedding wedding;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "guest")
	private Person guest;
	
	@OneToOne
	@JoinColumn(name = "present")
	private Present present;
	
	@Basic
	private Boolean attending;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Basic
	private Family family;

	public Invitation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	public Person getGuest() {
		return guest;
	}

	public void setGuest(Person guest) {
		this.guest = guest;
	}

	public Present getPresent() {
		return present;
	}

	public void setPresent(Present present) {
		this.present = present;
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
