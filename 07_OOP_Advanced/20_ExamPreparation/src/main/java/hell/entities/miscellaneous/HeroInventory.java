package hell.entities.miscellaneous;

import hell.entities.items.CommonItem;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<String, Item>();
        this.recipeItems = new LinkedHashMap<String, Recipe>();
    }

    @Override
    public long getTotalStrengthBonus() {
    	long res = 0l;
    	List<Item> ns = new ArrayList<>(this.commonItems.values());
    	for (Item item : ns) {
			res += this.getInLongValue(item.getStrengthBonus());
		}
        return res;
    }

    @Override
    public long getTotalAgilityBonus() {
    	long res = 0l;
    	List<Item> ns = new ArrayList<>(this.commonItems.values());
    	for (Item item : ns) {
			res += this.getInLongValue(item.getAgilityBonus());
		}
        return res;
    }

    @Override
    public long getTotalIntelligenceBonus() {
    	long res = 0l;
    	List<Item> ns = new ArrayList<>(this.commonItems.values());
    	for (Item item : ns) {
			res += this.getInLongValue(item.getIntelligenceBonus());
		}
    	return res;
    }

    @Override
    public long getTotalHitPointsBonus() {
    	long res = 0l;
    	List<Item> ns = new ArrayList<>(this.commonItems.values());
    	for (Item item : ns) {
			res += this.getInLongValue(item.getHitPointsBonus());
		}
        return res;
    }

    @Override
    public long getTotalDamageBonus() {
    	long res = 0l;
    	List<Item> ns = new ArrayList<>(this.commonItems.values());
    	for (Item item : ns) {
			res += this.getInLongValue(item.getDamageBonus());
		}
        return res;
    }

    @Override
    public void addCommonItem(Item item) {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() {
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    requiredItems.remove(item.getName());
                }
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
                break;
            }
        }
    }

    private void combineRecipe(Recipe recipe) {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        Item newItem = new CommonItem(recipe.getName(), recipe.getStrengthBonus(),
        		recipe.getAgilityBonus(), recipe.getIntelligenceBonus(),
        		recipe.getHitPointsBonus(), recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
        this.recipeItems.remove(recipe.getName());
    }
    
    private long getInLongValue(int n) {
		if (n >= 0) {
			return n;
		}
		return (long)(Integer.MAX_VALUE + ((Math.abs(Integer.MIN_VALUE) - n) + 1L));
	}
}