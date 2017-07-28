package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SuperBald")
public class SuperBald extends BasicShampoo {

}
