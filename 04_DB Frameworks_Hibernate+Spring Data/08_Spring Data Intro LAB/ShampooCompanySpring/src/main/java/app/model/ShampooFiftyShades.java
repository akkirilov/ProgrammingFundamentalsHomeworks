package app.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FiftyShades")
public class ShampooFiftyShades extends BasicShampoo{

	public ShampooFiftyShades() {  }
	
	public ShampooFiftyShades(ClassicLabel label, ProductionBatch batch, Set<BasicIngredient> ingredients) {
		super("Nashenski", new BigDecimal("104.99"), label, batch, ingredients);
	}

}
