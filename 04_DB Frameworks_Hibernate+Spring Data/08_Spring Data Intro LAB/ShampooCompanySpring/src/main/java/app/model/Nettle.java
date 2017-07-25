package app.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Nettle")
public class Nettle extends BasicIngredient{

	public Nettle() {
		super("Nettle", new BigDecimal("0.67"));
	}
	
}
