package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.interfaces.Hero;
import hell.interfaces.HeroFactory;
import hell.interfaces.Inventory;
import hell.utils.Constants;

public class HeroFactoryImpl implements HeroFactory {

	@Override
	public Hero create(String heroName, String heroType, Inventory heroInventory) {
		switch (heroType) {
		case Constants.ASSASSIN_TYPE:
			return new Assassin(heroName, heroInventory);
		case Constants.BARBARIAN_TYPE:
			return new Barbarian(heroName, heroInventory);
		case Constants.WIZARD_TYPE:
			return new Wizard(heroName, heroInventory);
		default:
			return null;
		}
	}

}
