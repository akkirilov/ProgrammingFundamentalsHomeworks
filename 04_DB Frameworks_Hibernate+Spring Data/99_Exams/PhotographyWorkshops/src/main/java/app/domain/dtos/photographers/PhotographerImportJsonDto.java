package app.domain.dtos.photographers;

import java.util.HashSet;
import java.util.Set;

public class PhotographerImportJsonDto {
	
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private Set<Long> lenses;
	
	public PhotographerImportJsonDto() {
		super();
		this.lenses = new HashSet<>();
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
