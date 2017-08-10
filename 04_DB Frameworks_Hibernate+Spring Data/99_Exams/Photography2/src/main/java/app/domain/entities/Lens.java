package app.domain.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lenses")
public class Lens implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	private String make;
	
	@Column(name = "focal_length")
	private Integer focalLength;
	
	@Column(name = "max_aperture")
	private Double maxAperture;
	
	@Column(name = "compatible_with")
	private String compatibleWith;
	
	@ManyToOne()
	@JoinColumn(name = "photographer_id")
	private Photographer owner;

	public Lens() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(Integer focalLength) {
		this.focalLength = focalLength;
	}

	public Double getMaxAperture() {
		return maxAperture;
	}

	public void setMaxAperture(Double maxAperture) {
		this.maxAperture = maxAperture;
	}

	public String getCompatibleWith() {
		return compatibleWith;
	}

	public void setCompatibleWith(String compatibleWith) {
		this.compatibleWith = compatibleWith;
	}

	public Photographer getOwner() {
		return owner;
	}

	public void setOwner(Photographer owner) {
		this.owner = owner;
	}

}
