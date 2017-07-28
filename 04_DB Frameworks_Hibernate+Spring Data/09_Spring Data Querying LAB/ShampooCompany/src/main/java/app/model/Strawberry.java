package app.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "strawberries")
@PrimaryKeyJoinColumn(name = "id")
public class Strawberry extends BasicIngredient {

    public Strawberry() {
        super("Strawberry", BigDecimal.valueOf(0.22));
    }


}
