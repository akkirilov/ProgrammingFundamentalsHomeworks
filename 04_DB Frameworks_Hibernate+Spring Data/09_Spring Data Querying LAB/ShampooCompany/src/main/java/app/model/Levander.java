package app.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "levanders")
@PrimaryKeyJoinColumn(name = "id")
public class Levander extends BasicIngredient {

    public Levander() {
        super("Levander", BigDecimal.valueOf(0.98));
    }

}
