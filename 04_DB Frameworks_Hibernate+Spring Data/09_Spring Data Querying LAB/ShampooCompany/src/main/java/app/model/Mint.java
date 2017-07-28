package app.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "mints")
@PrimaryKeyJoinColumn(name = "id")
public class Mint extends BasicIngredient {

    public Mint() {
        super("Mint", BigDecimal.valueOf(0.34));
    }

}
