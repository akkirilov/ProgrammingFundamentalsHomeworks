package app.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "weddings")
public class Wedding {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "bride")
	private Person bride;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "bridegroom")
	private Person bridegroom;
	
	@NotNull
	@Basic
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name = "agency_id")
	private Agency agency;

	@ManyToMany()
	@JoinTable(name = "weddings_venues", 
			joinColumns = @JoinColumn(name = "wedding_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "venue_id", referencedColumnName = "id"))
	private Set<Venue> venues;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "wedding_id")
	private Set<Invitation> invitations;

	public Wedding() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getBride() {
		return bride;
	}

	public void setBride(Person bride) {
		this.bride = bride;
	}

	public Person getBridegroom() {
		return bridegroom;
	}

	public void setBridegroom(Person bridegroom) {
		this.bridegroom = bridegroom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Set<Venue> getVenues() {
		return venues;
	}

	public void setVenues(Set<Venue> venues) {
		this.venues = venues;
	}

	public Set<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}
	
}
