package model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "checking_accounts")
public class CheckingAccount extends Account {
	
	@Basic
	private Double fee;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(String accountNumber, Double balance, Double fee) {
		super(accountNumber, balance);
		this.fee = fee;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	public void deductFee(Double deductFee) {
		if (deductFee <= this.fee) {
			this.fee -= deductFee;
		} else {
			System.out.println("Your fee can't be negative! THIS IS BANK!");
		}
	}
	
}
