package p10_InfernoInfinity.factories;

import p10_InfernoInfinity.entities.Weapon;
import p10_InfernoInfinity.entities.weapons.*;

public class WeaponFactory {

	public static Weapon create(String type, String name) {
		type = type.toUpperCase();
		switch (type) {
		case "AXE":
			return new Axe(name);
		case "SWORD":
			return new Sword(name);
		case "KNIFE":
			return new Knife(name);
		default:
			return null;
		}
	}
	
}
