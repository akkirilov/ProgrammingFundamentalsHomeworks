package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "emergancy_phone")
	private String emergancyPhone;
	
	@Column(name = "emergancy_name")
	private String emergancyName;
	
	@Basic
	private String notes;

	public Customer() {  }

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergancyPhone() {
		return emergancyPhone;
	}

	public void setEmergancyPhone(String emergancyPhone) {
		this.emergancyPhone = emergancyPhone;
	}

	public String getEmergancyName() {
		return emergancyName;
	}

	public void setEmergancyName(String emergancyName) {
		this.emergancyName = emergancyName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
