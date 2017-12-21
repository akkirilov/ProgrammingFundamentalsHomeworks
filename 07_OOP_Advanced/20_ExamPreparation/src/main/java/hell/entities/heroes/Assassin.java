package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Assassin extends AbstractHero {
	
	private final static long STRENGTH = 25;
	private final static long AGILITY = 100;
	private final static long INTELLIGENCE = 15;
	private final static long HIT_POINTS = 150;
	private final static long DAMAGE = 300;

	public Assassin(String name, Inventory heroInventory) {
		super(name, STRENGTH, AGILITY, INTELLIGENCE, HIT_POINTS, DAMAGE, heroInventory);
	}

}
