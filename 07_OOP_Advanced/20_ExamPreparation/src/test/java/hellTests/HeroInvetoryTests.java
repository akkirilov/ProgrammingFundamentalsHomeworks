package hellTests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

public class HeroInvetoryTests {
	
	private final static int ZERO = 0;
	private final static int TWO_BIL = 2000000000;
	private final static long FOUR_BIL = 4000000000L;
	
	private Inventory inventory;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Recipe recipe1;
	private Recipe recipe2;
	
	@Before
	public void initialization() {
		this.inventory = new HeroInventory();
		this.item1 = Mockito.mock(Item.class);
		this.item2 = Mockito.mock(Item.class);
		this.item3 = Mockito.mock(Item.class);
		this.item4 = Mockito.mock(Item.class);
		this.item5 = Mockito.mock(Item.class);
		this.recipe1 = Mockito.mock(Recipe.class);
		this.recipe2 = Mockito.mock(Recipe.class);
		Mockito.when(item1.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(item2.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(item3.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(item4.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(item5.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe1.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe2.getDamageBonus()).thenReturn(TWO_BIL);
		Mockito.when(item1.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(item2.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(item3.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(item4.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(item5.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe1.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe2.getAgilityBonus()).thenReturn(TWO_BIL);
		Mockito.when(item1.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(item2.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(item3.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(item4.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(item5.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe1.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe2.getHitPointsBonus()).thenReturn(TWO_BIL);
		Mockito.when(item1.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(item2.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(item3.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(item4.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(item5.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe1.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe2.getIntelligenceBonus()).thenReturn(TWO_BIL);
		Mockito.when(item1.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(item2.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(item3.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(item4.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(item5.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe1.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(recipe2.getStrengthBonus()).thenReturn(TWO_BIL);
		Mockito.when(item1.getName()).thenReturn("one");
		Mockito.when(item2.getName()).thenReturn("two");
		Mockito.when(item3.getName()).thenReturn("three");
		Mockito.when(item4.getName()).thenReturn("four");
		Mockito.when(item5.getName()).thenReturn("five");
		Mockito.when(recipe1.getName()).thenReturn("six");
		Mockito.when(recipe2.getName()).thenReturn("seven");
		Mockito.when(recipe1.getRequiredItems()).thenReturn(Arrays.asList("one", "two"));
		Mockito.when(recipe2.getRequiredItems()).thenReturn(Arrays.asList("one", "two"));
	}
	
	@Test
	public void addAndCountTotalsByCommonItem() {
		this.inventory.addCommonItem(item1);
		this.inventory.addCommonItem(item2);
		Assert.assertEquals(FOUR_BIL, this.inventory.getTotalDamageBonus());
		Assert.assertEquals(FOUR_BIL, this.inventory.getTotalAgilityBonus());
		Assert.assertEquals(FOUR_BIL, this.inventory.getTotalHitPointsBonus());
		Assert.assertEquals(FOUR_BIL, this.inventory.getTotalIntelligenceBonus());
		Assert.assertEquals(FOUR_BIL, this.inventory.getTotalStrengthBonus());
	}
	
	@Test
	public void addAndCountTotalsByRecipeItem() {
		this.inventory.addCommonItem(item1);
		this.inventory.addCommonItem(item2);
		this.inventory.addRecipeItem(recipe1);
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalDamageBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalAgilityBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalHitPointsBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalIntelligenceBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalStrengthBonus());
	}
	
	@Test
	public void addAndCountTotalsByCollectingItemsForRecipeItem() {
		this.inventory.addRecipeItem(recipe1);
		this.inventory.addCommonItem(item1);
		this.inventory.addCommonItem(item2);
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalDamageBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalAgilityBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalHitPointsBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalIntelligenceBonus());
		Assert.assertEquals(TWO_BIL, this.inventory.getTotalStrengthBonus());
	}
	
	@Test
	public void addOnlyRecipeItem() {
		this.inventory.addRecipeItem(recipe1);
		Assert.assertEquals(ZERO, this.inventory.getTotalDamageBonus());
		Assert.assertEquals(ZERO, this.inventory.getTotalAgilityBonus());
		Assert.assertEquals(ZERO, this.inventory.getTotalHitPointsBonus());
		Assert.assertEquals(ZERO, this.inventory.getTotalIntelligenceBonus());
		Assert.assertEquals(ZERO, this.inventory.getTotalStrengthBonus());
	}

}
