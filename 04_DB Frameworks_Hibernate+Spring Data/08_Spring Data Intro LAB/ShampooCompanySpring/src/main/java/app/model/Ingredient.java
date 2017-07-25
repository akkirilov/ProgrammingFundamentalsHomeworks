package app.model;

import java.math.BigDecimal;

public interface Ingredient {

	long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

}
