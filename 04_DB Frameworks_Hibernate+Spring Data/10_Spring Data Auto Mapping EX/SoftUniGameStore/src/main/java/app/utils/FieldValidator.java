package app.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class FieldValidator {
	
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	public static <T> String getInvalidMessage(T target){  
		
		Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
		for (ConstraintViolation<T> constraint : constraints) {
			return constraint.getMessage();
		}
		return null;	
	}
	
}
