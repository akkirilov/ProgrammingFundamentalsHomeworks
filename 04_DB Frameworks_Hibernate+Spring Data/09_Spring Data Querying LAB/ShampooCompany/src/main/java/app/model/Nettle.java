package app.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "nettles")
@PrimaryKeyJoinColumn(name = "id")
public class Nettle extends BasicIngredient {

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(0.54));
    }

}
