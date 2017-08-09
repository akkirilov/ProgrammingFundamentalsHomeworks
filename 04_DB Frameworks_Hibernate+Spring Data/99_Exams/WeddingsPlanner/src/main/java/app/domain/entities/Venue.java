package app.domain.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venues")
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	private String name;
	
	@Basic
	private Integer capacity;
	
	@Basic
	private String town;
	
	@ManyToMany(mappedBy = "venues", fetch = FetchType.EAGER)
	private Set<Wedding> weddings;

	public Venue() {
		super();
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Set<Wedding> getWeddings() {
		return weddings;
	}

	public void setWeddings(Set<Wedding> weddings) {
		this.weddings = weddings;
	}
	
}
