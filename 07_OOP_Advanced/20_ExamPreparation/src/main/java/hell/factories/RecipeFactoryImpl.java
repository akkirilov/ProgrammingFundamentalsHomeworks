package hell.factories;

import java.util.List;

import hell.entities.items.RecipeItem;
import hell.interfaces.Recipe;
import hell.interfaces.RecipeFactory;

public class RecipeFactoryImpl implements RecipeFactory {

	@Override
	public Recipe create(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
			int damageBonus, List<String> requiredItems) {
		return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
	}

}
