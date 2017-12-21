package hell.interfaces;

import java.util.List;

public interface Manager {
	
	String registerHero(String heroName, String heroType);
	
	String registerItem(String name, String heroName, int strengthBonus, int agilityBonus, 
			int intelligenceBonus, int hitPointsBonus, int damageBonus);
	
	String registerRecipe(String name, String heroName, int strengthBonus, int agilityBonus, 
			int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> requiredItems);
	
	String inspectHero(String heroName);
	
	String quit();

}
