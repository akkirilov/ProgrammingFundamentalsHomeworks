package hell.utils;

public class Constants {
	
	public final static String REGISTER_HERO_FORMAT = "Created %s - %s";
	public static final String REGISTER_ITEM_FORMAT = "Added item - %s to Hero - %s";
	public static final String REGISTER_RECIPE_FORMAT = "Added recipe - %s to Hero - %s";
	public static final String INSPECT_HERO_FORMAT = "Hero: %s, Class: %s%n" 
														+ "HitPoints: %d, Damage: %d%n"
														+ "Strength: %d%n"
														+ "Agility: %d%n"
														+ "Intelligence: %d";
	public static final String QUIT_HERO_FORMAT = "%d. %s: %s%n"
													+ "###HitPoints: %d%n"
													+ "###Damage: %d%n"
													+ "###Strength: %d%n"
													+ "###Agility: %d%n"
													+ "###Intelligence: %d%n"
													+ "###Items: ";
	public static final String INSPECT_ITEM_FORMAT = "###Item: %s%n"
														+ "###+%d Strength%n"
														+ "###+%d Agility%n"
														+ "###+%d Intelligence%n"
														+ "###+%d HitPoints%n"
														+ "###+%d Damage";
	
	public final static String BARBARIAN_TYPE = "Barbarian";
	public final static String ASSASSIN_TYPE = "Assassin";
	public final static String WIZARD_TYPE = "Wizard";
	
	public final static String HERO_INVENTORY_TYPE = "Hero";
	
	public final static String REGISTER_HERO_COMMAND = "Hero";
	public final static String REGISTER_ITEM_COMMAND = "Item";
	public final static String REGISTER_RECIPE_COMMAND = "Recipe";
	public final static String INSPECT_HERO_COMMAND = "Inspect";
	public final static String TERMINATION_COMMAND = "Quit";

}
