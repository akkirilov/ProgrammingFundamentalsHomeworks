package p02_Blob.factories;

import p02_Blob.interfaces.Attack;

public class AttackFactory {

	private final static String BASE_PATH = "p02_Blob.models.attacks.";

	public static Attack create (String attackType) {
		try {
			Class clazz = Class.forName(BASE_PATH + attackType);
			Attack attack = (Attack) clazz.newInstance();
			return attack;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
}
