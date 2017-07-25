package app.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Strawberry")
public class Strawberry extends BasicIngredient{

	public Strawberry() {
		super("Strawberry", new BigDecimal("0.98"));
	}
	
}
