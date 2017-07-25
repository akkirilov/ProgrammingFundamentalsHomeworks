package app.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PinkPanther")
public class ShampooPinkPanther extends BasicShampoo{

	public ShampooPinkPanther() {  }
	
	public ShampooPinkPanther(ClassicLabel label, ProductionBatch batch, Set<BasicIngredient> ingredients) {
		super("Nashenski", new BigDecimal("94.99"), label, batch, ingredients);
	}

}
