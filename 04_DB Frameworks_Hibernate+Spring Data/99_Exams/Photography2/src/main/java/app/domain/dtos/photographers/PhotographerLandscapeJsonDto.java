package app.domain.dtos.photographers;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotographerLandscapeJsonDto implements Serializable {

	@Expose
	@SerializedName(value = "FirstName")
	private String firstName;

	@Expose
	@SerializedName(value = "LastName")
	private String lastName;

	@Expose
	@SerializedName(value = "CameraMake")
	private String primaryCameraMake;

	@Expose
	@SerializedName(value = "LensesCount")
	private Integer count;
	
	public PhotographerLandscapeJsonDto() {
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
