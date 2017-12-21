package hell.interfaces;

/**
 *  This is the interface for the Inventory
 *  @method long getTotalStrength() - a method which returns the total Strength bonus from all CommonItems stored in the Inventory
 *  @method long getTotalAgility() - a method which returns the total Agility bonus from all CommonItems stored in the Inventory
 *  @method long getTotalIntelligence() - a method which returns the total Intelligence bonus from all CommonItems stored in the Inventory
 *  @method long getTotalHitPoints() - a method which returns the total HitPoints bonus from all CommonItems stored in the Inventory
 *  @method long getTotalDamage() - a method which returns the total Damage bonus from all CommonItems stored in the Inventory
 *  @method void addCommonItem(Item item) - a method which adds an CommonItem to the Inventory
 *  @method void addRecipeItem(Recipe item) - a method which adds an RecipeItem to the Inventory
 */
public interface InventoryFactory {
	
   Inventory create(String inventoryType);
	
}