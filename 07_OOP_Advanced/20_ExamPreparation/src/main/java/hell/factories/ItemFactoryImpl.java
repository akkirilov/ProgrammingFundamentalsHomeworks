package hell.factories;

import hell.entities.items.CommonItem;
import hell.interfaces.Item;
import hell.interfaces.ItemFactory;

public class ItemFactoryImpl implements ItemFactory {

	@Override
	public Item create(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
			int damageBonus) {
		return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
	}

}
