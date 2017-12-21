package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends AbstractHero {
	
	private final static long STRENGTH = 90;
	private final static long AGILITY = 25;
	private final static long INTELLIGENCE = 10;
	private final static long HIT_POINTS = 350;
	private final static long DAMAGE = 150;

	public Barbarian(String name, Inventory heroInventory) {
		super(name, STRENGTH, AGILITY, INTELLIGENCE, HIT_POINTS, DAMAGE, heroInventory);
	}

}
