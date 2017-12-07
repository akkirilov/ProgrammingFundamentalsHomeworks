package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interfaces.Target;
import interfaces.Weapon;

public class DummyTests {
	
	private final static Integer DEFAULT_AXE_ATACK = 4;
	private final static Integer DEFAULT_AXE_DURABILITY = 5;
	private final static Integer DEFAULT_DUMMY_HEALTH = 5;
	private final static Integer DEFAULT_DUMMY_EXPERIENCE = 5;
	private final static String DUMMY_LOSE_HEALTH_MSG = "Dummy don't lose health!";
	private final static String DEAD_DUMMY_GIVE_EXPERIENCE_MSG = "Dead dummy don't give experience!";
	
	private Weapon weapon;
	private Target target;
	private Hero hero;
	
	@Before
	public void beforeTests() {
		weapon = new Axe(DEFAULT_AXE_ATACK, DEFAULT_AXE_DURABILITY);
		target = new Dummy(DEFAULT_DUMMY_HEALTH, DEFAULT_DUMMY_EXPERIENCE);
		hero = new Hero("Batkata", this.weapon);
	}
	
	@Test
	public void dummyLosesHealth() {
		weapon.attack(target);
		Assert.assertEquals(DUMMY_LOSE_HEALTH_MSG, (DEFAULT_DUMMY_HEALTH - DEFAULT_AXE_ATACK), target.getHealth());
	}
	
	@Test(expected = IllegalStateException.class)
	public void deadDummyThrowException() {
		weapon.attack(target);
		weapon.attack(target);
		weapon.attack(target);
		weapon.attack(target);
		weapon.attack(target);
		weapon.attack(target);
	}
	
	@Test
	public void deadDummyGiveExperience() {
		hero.attack(target);
		hero.attack(target);
		int expectedHeroExperience = (hero.getExperience() - target.giveExperience()) + target.giveExperience();
		Assert.assertEquals(DEAD_DUMMY_GIVE_EXPERIENCE_MSG, expectedHeroExperience, hero.getExperience());
	}
	
	@Test(expected = IllegalStateException.class)
	public void aliveDummyCantGiveExperience() {
		hero.attack(target);
		target.giveExperience();
	}
	
}
