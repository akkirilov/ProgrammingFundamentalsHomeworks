package app.models;

import java.math.BigDecimal;

import app.enums.AgeRestriction;
import app.enums.EditionType;

public interface ReducedBook {

	AgeRestriction getAgeRestriction();
	
	EditionType getEdition();
	
	BigDecimal getPrice();
	
	String getTitle();
	
}
