package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CreditCard")
public class CreditCard extends BillingDetails{
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "expiration_month")
	private Integer expirationMonth;
	
	@Column(name = "expiration_Year")
	private Integer expirationYear;

	public CreditCard() {
		super();
	}

	public CreditCard(String cardType, Integer expirationMonth, Integer expirationYear) {
		super();
		this.cardType = cardType;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
		
}
