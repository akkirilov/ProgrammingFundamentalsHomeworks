package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BankAccount")
public class BankAccount extends BillingDetails {

	@Basic
	private String name;
	
	@Column(name = "swift_code")
	private String swiftCode;

	public BankAccount() {
		super();
	}

	public BankAccount(String name, String swiftCode) {
		super();
		this.name = name;
		this.swiftCode = swiftCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
		
}
