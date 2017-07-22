package model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Levander")
public class Levander extends BasicIngredient{

	public Levander() {
		super("Levander", new BigDecimal("0.65"));
	}
	
}
