package app.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AmmoniumChloride")
public class AmmoniumChloride extends BasicChemicalIngredient{

	public AmmoniumChloride() {
		super("N4H2O5", "AmmoniumChloride", new BigDecimal("1.21"));
	}
		
}
