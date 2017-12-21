package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.InventoryFactory;
import hell.utils.Constants;

public class InventoryFactoryImpl implements InventoryFactory {

	@Override
	public Inventory create(String inventoryType) {
		switch (inventoryType) {
		case Constants.HERO_INVENTORY_TYPE:
			return new HeroInventory();
		default:
			return null;
		}
	}
	
}
