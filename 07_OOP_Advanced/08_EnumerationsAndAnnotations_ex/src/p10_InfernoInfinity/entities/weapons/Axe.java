package p10_InfernoInfinity.entities.weapons;

import p10_InfernoInfinity.entities.WeaponBase;

public class Axe extends WeaponBase {
	
	private static int MIN_DAMAGE = 5;
	private static int MAX_DAMAGE = 10;
	private static int NUMBER_OF_SOCKETS = 4;
	
	public Axe(String name) {
		super(name, MIN_DAMAGE, MAX_DAMAGE, NUMBER_OF_SOCKETS);
	}

}
