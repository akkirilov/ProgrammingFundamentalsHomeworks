package app.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("cash")
public class Cash extends Present implements Serializable {

	@NotNull
	@Column(name = "cash_amount")
	private BigDecimal cashAmount;

	public Cash() {
		super();
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}
	
}
