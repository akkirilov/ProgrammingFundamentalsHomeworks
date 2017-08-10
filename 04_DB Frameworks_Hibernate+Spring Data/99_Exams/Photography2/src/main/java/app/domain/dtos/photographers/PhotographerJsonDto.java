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

public class PhotographerJsonDto implements Serializable {

	@Expose
	private String firstName;

	@Expose
	private String lastName;

	@Expose
	private String phone;

	@Expose
	Set<Long> lenses;
	
	public PhotographerJsonDto() {
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

	public Set<Long> getLenses() {
		return lenses;
	}

	public void setLenses(Set<Long> lenses) {
		this.lenses = lenses;
	}

}
