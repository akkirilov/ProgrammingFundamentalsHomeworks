package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "saving_accounts")
public class SavingAccount extends Account{

	@Column(name = "interest_rate")
	private Double interestRate;

	public SavingAccount() {
		super();
	}

	public SavingAccount(String accountNumber, Double balance, Double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void addInterest(Double interest) {
		this.interestRate += interest;
	}
	
}
