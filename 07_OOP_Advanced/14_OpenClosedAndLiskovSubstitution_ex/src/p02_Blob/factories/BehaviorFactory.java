package p02_Blob.factories;

import p02_Blob.interfaces.Behavior;

public class BehaviorFactory {
	
	private final static String BASE_PATH = "p02_Blob.models.behavors.";

	public static Behavior create (String behaviorType) {
		try {
			Class clazz = Class.forName(BASE_PATH + behaviorType);
			Behavior behavior = (Behavior) clazz.newInstance();
			return behavior;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
}
