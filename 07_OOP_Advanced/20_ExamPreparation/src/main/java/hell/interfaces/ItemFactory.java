package hell.interfaces;

public interface ItemFactory {
	
	Item create(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
			int hitPointsBonus, int damageBonus); 

}
