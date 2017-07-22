package model;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {

	long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    ClassicLabel getLabel();

    void setLabel(ClassicLabel label);

    ProductionBatch getBatch();

    void setBatch(ProductionBatch batch);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
	
}
