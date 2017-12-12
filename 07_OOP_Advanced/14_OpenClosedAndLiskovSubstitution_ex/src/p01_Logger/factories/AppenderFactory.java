package p01_Logger.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import p01_Logger.interfaces.Appender;
import p01_Logger.interfaces.Layout;
import p01_Logger.models.appenders.FileAppender;
import p01_Logger.models.files.LogFile;

public class AppenderFactory {

	private final static String BASE_PATH =  "p01_Logger.models.appenders.";
	
	public static Appender create(String appenderString, Layout layout) {
		try {
			Class clazz = Class.forName(BASE_PATH + appenderString);
			Constructor<?> constructor = clazz.getConstructor(Layout.class);
			Appender appender = (Appender) constructor.newInstance(layout);
			if (appenderString.startsWith("File")) {
				((FileAppender)appender).setFile(new LogFile());
			}
			return appender;
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | NoSuchMethodException 
				| SecurityException | IllegalArgumentException 
				| InvocationTargetException e) {
			return null;
		}
	}
	
}
