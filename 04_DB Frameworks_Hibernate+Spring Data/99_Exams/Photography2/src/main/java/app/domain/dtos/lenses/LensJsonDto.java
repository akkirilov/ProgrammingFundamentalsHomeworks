package app.domain.dtos.lenses;

import java.io.Serializable;

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

import com.google.gson.annotations.Expose;

public class LensJsonDto implements Serializable {

	@Expose
	private Integer focalLength;

	@Expose
	private String make;
	
	@Expose
	private Double maxAperture;

	@Expose
	private String compatibleWith;

	public LensJsonDto() {
		super();
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

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

}
