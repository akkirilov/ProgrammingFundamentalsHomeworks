package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PinkPanter")
public class PinkPanter extends BasicShampoo {

}
