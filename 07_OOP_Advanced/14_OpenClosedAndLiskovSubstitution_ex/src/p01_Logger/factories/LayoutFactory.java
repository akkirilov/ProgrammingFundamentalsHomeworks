package p01_Logger.factories;

import p01_Logger.interfaces.Layout;

public class LayoutFactory {
	
	private final static String BASE_PATH =  "p01_Logger.models.layouts.";
	
	public static Layout create(String layoutString) {
		try {
			Class<?> clazz = Class.forName(BASE_PATH + layoutString);
			Layout layout =  (Layout) clazz.newInstance();
			return layout;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

}
