package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Wizard extends AbstractHero {
	
	private final static long STRENGTH = 25;
	private final static long AGILITY = 25;
	private final static long INTELLIGENCE = 100;
	private final static long HIT_POINTS = 100;
	private final static long DAMAGE = 250;

	public Wizard(String name, Inventory heroInventory) {
		super(name, STRENGTH, AGILITY, INTELLIGENCE, HIT_POINTS, DAMAGE, heroInventory);
	}

}
