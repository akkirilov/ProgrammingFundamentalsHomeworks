package factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import contracts.IEngine;

public class EngineFactory {
	
	private final static String BASE_PATH = "models.boatEngines.";

	public static IEngine create(String model, int horsepower, int displacement, String engineType) {
		try {
			Class<?> clazz = Class.forName(BASE_PATH + engineType);
			@SuppressWarnings("unchecked")
			Constructor<IEngine> constructor = (Constructor<IEngine>) clazz.getConstructor(String.class, int.class, int.class);
			return constructor.newInstance(model, horsepower, displacement);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException 
				| NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
	
}
