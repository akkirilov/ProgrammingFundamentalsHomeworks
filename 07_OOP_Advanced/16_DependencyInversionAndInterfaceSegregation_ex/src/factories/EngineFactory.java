package factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import contracts.IEngine;
import models.boatEngines.Jet;
import models.boatEngines.Sterndrive;
import utilities.Constants;
import utilities.Validator;

public class EngineFactory {
	
	private final static String BASE_PATH = "models.boatEngines.";

	public static IEngine create(String model, int horsepower, int displacement, String engineType) {
		Validator.validateModelLength(model, Constants.MinBoatEngineModelLength);
//		try {
//			Class<?> clazz = Class.forName(BASE_PATH + engineType);
//			@SuppressWarnings("unchecked")
//			Constructor<IEngine> constructor = (Constructor<IEngine>) clazz.getConstructor(String.class, int.class, int.class);
//			IEngine engine = constructor.newInstance(model, horsepower, displacement);
//			return engine;
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
//				| InvocationTargetException 
//				| NoSuchMethodException | SecurityException e) {
//			return null;
//		}
		if (engineType.equalsIgnoreCase("Jet")) {
			return new Jet(model, horsepower, displacement);
		} else {
			return new Sterndrive(model, horsepower, displacement);
		}
	}
	
}
