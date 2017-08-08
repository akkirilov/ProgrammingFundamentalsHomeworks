package app.domain.dtos.photographers;

import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import app.domain.entities.Lens;

public class LandscapePhotographerExportJsonDto {
	
	@Expose
	@SerializedName(value = "FirstName")
	private String firstName;

	@Expose
	@SerializedName(value = "LastName")
	private String lastName;
	
	@Expose
	@SerializedName(value = "CameraMake")
	private String primaryCameraMake;
	
	private Set<Lens> lenses;
	
	@Expose
	@SerializedName(value = "LensesCount")
	private Integer lensesCount;

	public LandscapePhotographerExportJsonDto() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryCameraMake() {
		return primaryCameraMake;
	}

	public void setPrimaryCameraMake(String primaryCameraMake) {
		this.primaryCameraMake = primaryCameraMake;
	}

	public Set<Lens> getLenses() {
		return lenses;
	}

	public void setLenses(Set<Lens> lenses) {
		this.lenses = lenses;
	}

	public Integer getLensesCount() {
		return this.lenses.size();
	}

	public void setLensesCount(Integer lensesCount) {
		this.lensesCount = lensesCount;
	}

	
	
}
