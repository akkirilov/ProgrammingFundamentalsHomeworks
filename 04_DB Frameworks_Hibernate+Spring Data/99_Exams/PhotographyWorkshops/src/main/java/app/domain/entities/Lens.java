package app.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "lenses")
public class Lens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "make")
	private String make;	

	@Column(name = "focal_length")
	private Integer focalLength;

	@Digits(integer = Integer.MAX_VALUE, fraction = 1)
	@Column(name = "max_aperture")
	private Double maxAperture;
	
	@Column(name = "compatible_with")
	private String compatibleWith;

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

}
