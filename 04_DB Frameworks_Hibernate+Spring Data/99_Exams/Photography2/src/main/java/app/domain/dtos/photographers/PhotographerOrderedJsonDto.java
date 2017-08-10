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

public class PhotographerOrderedJsonDto implements Serializable {

	@Expose
	@SerializedName(value = "FirstName")
	private String firstName;

	@Expose
	@SerializedName(value = "LastName")
	private String lastName;

	@Expose
	@SerializedName(value = "Phone")
	private String phone;
	
	public PhotographerOrderedJsonDto() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
