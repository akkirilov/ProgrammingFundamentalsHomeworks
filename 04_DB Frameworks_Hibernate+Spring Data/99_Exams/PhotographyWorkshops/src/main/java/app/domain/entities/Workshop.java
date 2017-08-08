package app.domain.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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

@Entity
@Table(name = "workshops")
public class Workshop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@NotNull
	@Column(name = "location")
	private String location;

	@NotNull
	@Column(name = "price_per_participant")
	private BigDecimal pricePerParticipant;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "trainer", referencedColumnName = "id")
	private Photographer trainer;
	
	@ManyToMany
	@JoinTable(name = "worshops_photographers",
			joinColumns = @JoinColumn(name = "workshop_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "id"))
	private Set<Photographer> participants;

	public Workshop() {
		super();
		this.participants = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getPricePerParticipant() {
		return pricePerParticipant;
	}

	public void setPricePerParticipant(BigDecimal pricePerParticipant) {
		this.pricePerParticipant = pricePerParticipant;
	}

	public Photographer getTrainer() {
		return trainer;
	}

	public void setTrainer(Photographer trainer) {
		this.trainer = trainer;
	}

	public Set<Photographer> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Photographer> participants) {
		this.participants = participants;
	}
	
	public void addParticipant(Photographer participant) {
		this.participants.add(participant);
	}
	
}
