package app.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mint")
public class Mint extends BasicIngredient{

	public Mint() {
		super("Mint", new BigDecimal("0.87"));
	}
	
}
