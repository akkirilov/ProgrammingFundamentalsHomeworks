package p10_InfernoInfinity.entities.weapons;

import p10_InfernoInfinity.entities.WeaponBase;

public class Knife extends WeaponBase {

	private static int MIN_DAMAGE = 3;
	private static int MAX_DAMAGE = 4;
	private static int NUMBER_OF_SOCKETS = 2;
	
	public Knife(String name) {
		super(name, MIN_DAMAGE, MAX_DAMAGE, NUMBER_OF_SOCKETS);
	}

}
