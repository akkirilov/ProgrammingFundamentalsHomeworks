package hell.entities.heroes;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

public abstract class AbstractHero implements Hero {

	private String name;
	private long strength;
	private long agility;
	private long intelligence;
	private long hitPoints;
	private long damage;
	private Inventory heroInventory;

	protected AbstractHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage,
			Inventory heroInventory) {
		this.name = name;
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.heroInventory = heroInventory;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public long getStrength() {
		return this.strength + this.heroInventory.getTotalStrengthBonus();
	}

	@Override
	public long getAgility() {
		return this.agility + this.heroInventory.getTotalAgilityBonus();
	}

	@Override
	public long getIntelligence() {
		return this.intelligence + this.heroInventory.getTotalIntelligenceBonus();
	}

	@Override
	public long getHitPoints() {
		return this.hitPoints + this.heroInventory.getTotalHitPointsBonus();
	}

	@Override
	public long getDamage() {
		return this.damage + this.heroInventory.getTotalDamageBonus();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Item> getItems() {
		Field field = null;
		Field[] fields = this.heroInventory.getClass().getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(ItemCollection.class)) {
				field = f;
				break;
			}
		}
		field.setAccessible(true);
		try {
			return ((Map<String, Item>) field.get(this.heroInventory)).values();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addItem(Item item) {
		this.heroInventory.addCommonItem(item);
	}

	@Override
	public void addRecipe(Recipe recipe) {
		this.heroInventory.addRecipeItem(recipe);
	}
	
}
