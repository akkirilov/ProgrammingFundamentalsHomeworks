package hell.interfaces;

public interface HeroFactory {
	
	Hero create(String heroName, String heroType, Inventory heroInventory);

}
