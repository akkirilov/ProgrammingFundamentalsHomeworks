package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FreshNuke")
public class FreshNuke extends BasicShampoo {

}
