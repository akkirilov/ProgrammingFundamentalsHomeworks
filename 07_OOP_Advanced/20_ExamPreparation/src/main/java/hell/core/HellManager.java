package hell.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hell.interfaces.*;
import hell.utils.Constants;

public class HellManager implements Manager {
	
	private HeroFactory heroFactory;
	private ItemFactory itemFactory;
	private RecipeFactory recipeFactory;
	private InventoryFactory inventoryFactory;
	private Map<String, Hero> heroes;
	
	public HellManager(HeroFactory heroFactory, ItemFactory itemFactory, 
			RecipeFactory recipeFactory, InventoryFactory inventoryFactory) {
		this.heroes = new LinkedHashMap<>();
		this.heroFactory = heroFactory;
		this.itemFactory = itemFactory;
		this.recipeFactory = recipeFactory;
		this.inventoryFactory = inventoryFactory;
	}

	@Override
	public String registerHero(String heroName, String heroType) {
		Inventory heroInventory = this.inventoryFactory.create(Constants.HERO_INVENTORY_TYPE);
		Hero hero = this.heroFactory.create(heroName, heroType, heroInventory);
		this.heroes.put(heroName, hero);
		return String.format(Constants.REGISTER_HERO_FORMAT, heroType, heroName);
	}

	@Override
	public String registerItem(String name, String heroName, int strengthBonus, int agilityBonus, 
			int intelligenceBonus, int hitPointsBonus, int damageBonus) {
		Item item = this.itemFactory.create(name, strengthBonus, agilityBonus,  
				intelligenceBonus, hitPointsBonus, damageBonus); 
		this.heroes.get(heroName).addItem(item); 
		return String.format(Constants.REGISTER_ITEM_FORMAT, name, heroName); 
	}

	@Override 
	public String registerRecipe(String name, String heroName, int strengthBonus, int agilityBonus, 
			int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> requiredItems) {
		Recipe recipe = this.recipeFactory.create(name, strengthBonus, agilityBonus, 
				intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
		this.heroes.get(heroName).addRecipe(recipe);
		return String.format(Constants.REGISTER_RECIPE_FORMAT, name, heroName);
	}

	@Override
	public String inspectHero(String heroName) {
		Hero hero = this.heroes.get(heroName);
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(Constants.INSPECT_HERO_FORMAT, 
				hero.getName(), hero.getClass().getSimpleName(),
				hero.getHitPoints(), hero.getDamage(),
				hero.getStrength(), hero.getAgility(), hero.getIntelligence()));
		sb.append(System.lineSeparator())
		.append("Items:");
		if (hero.getItems() == null || hero.getItems().size() == 0) {
			sb.append(" None");
		} else {
			sb.append(System.lineSeparator());
			Collection<Item> items = hero.getItems();
			Iterator<Item> iterator = items.iterator();
			for (int i = 0; i < items.size(); i++) {
				Item item = iterator.next();
				sb.append(String.format(Constants.INSPECT_ITEM_FORMAT,
								item.getName(), this.getInLongValue(item.getStrengthBonus()), 
								this.getInLongValue(item.getAgilityBonus()),
								this.getInLongValue(item.getIntelligenceBonus()), 
								this.getInLongValue(item.getHitPointsBonus()), 
								this.getInLongValue(item.getDamageBonus())));
				if (i < items.size() - 1) {
					sb.append(System.lineSeparator());
				}
			}
		}
		return sb.toString();
	}

	@Override
	public String quit() {
		List<Hero> heroList = this.heroes.values()
				.stream()
				.sorted((a, b) -> {
					int res = Long.compare((b.getStrength() + b.getAgility() + b.getIntelligence()), 
							(a.getStrength() + a.getAgility() + a.getIntelligence()));
					if (res == 0) {
						res = Long.compare((b.getHitPoints() + b.getDamage()), 
								(a.getHitPoints() + a.getDamage()));
					}
					return res;
				})
				.collect(Collectors.toList());
		int counter = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < heroList.size(); i++) {
			Hero hero = heroList.get(i);
			sb.append(String.format(Constants.QUIT_HERO_FORMAT, 
									counter++, hero.getClass().getSimpleName(),
									hero.getName(), hero.getHitPoints(),
									hero.getDamage(), hero.getStrength(), hero.getAgility(),
									hero.getIntelligence()));
			if (hero.getItems() != null && hero.getItems().size() > 0) {
				Collection<Item> items = hero.getItems();
				Iterator<Item> iterator = items.iterator();
				for (int j = 0; j < items.size(); j++) {
					Item item = iterator.next();
					sb.append(item.getName());
					if (j < items.size() - 1) {
						sb.append(", ");
					} else {
						sb.append(System.lineSeparator());
					}
				}
			} else {
				sb.append("None");
				if (i < heroList.size() - 1) {
					sb.append(System.lineSeparator());
				}
			}
		}
		return sb.toString();
	}
	
	private long getInLongValue(int n) {
		if (n >= 0) {
			return n;
		}
		return (long)(Integer.MAX_VALUE + ((Math.abs(Integer.MIN_VALUE) - n) + 1L));
	}

}
