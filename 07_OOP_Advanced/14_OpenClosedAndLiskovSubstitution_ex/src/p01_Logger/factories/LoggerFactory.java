package p01_Logger.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Logger;
import p01_Logger.models.loggers.MessageLogger;

public class LoggerFactory {
	
	private final static String BASE_PATH =  "p01_Logger.models.loggers.";

	public static Logger create(String loggerString, Appender[] appenders) {
		try {
			Class clazz = Class.forName(BASE_PATH + loggerString);
			Constructor<?> constructor = clazz.getConstructor(Appender[].class);
			Logger logger = (Logger) constructor.newInstance(appenders);
			return logger;
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | NoSuchMethodException 
				| SecurityException | IllegalArgumentException 
				| InvocationTargetException e) {
			return new MessageLogger(appenders);
		}
	}

	public static Logger create(Appender[] appenders) {
		return new MessageLogger(appenders);
	}
	
}
