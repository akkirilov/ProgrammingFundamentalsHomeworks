package p10_InfernoInfinity.entities.weapons;

import p10_InfernoInfinity.entities.WeaponBase;

public class Sword extends WeaponBase {

	private static int MIN_DAMAGE = 4;
	private static int MAX_DAMAGE = 6;
	private static int NUMBER_OF_SOCKETS = 3;
	
	public Sword(String name) {
		super(name, MIN_DAMAGE, MAX_DAMAGE, NUMBER_OF_SOCKETS);
	}

}
