package app.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FreshNuke")
public class ShampooFreshNuke extends BasicShampoo{

	public ShampooFreshNuke() {  }
	
	public ShampooFreshNuke(ClassicLabel label, ProductionBatch batch, Set<BasicIngredient> ingredients) {
		super("Nashenski", new BigDecimal("999.99"), label, batch, ingredients);
	}

}
