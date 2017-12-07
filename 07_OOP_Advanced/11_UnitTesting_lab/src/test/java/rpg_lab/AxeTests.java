package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interfaces.Target;
import interfaces.Weapon;

public class AxeTests {
	
	private final static Integer DEFAULT_AXE_ATACK = 5;
	private final static Integer DEFAULT_AXE_DURABILITY = 1;
	private final static Integer DEFAULT_AXE_DURABILITY_LOSE = 1;
	private final static Integer DEFAULT_DUMMY_HEALTH = 5;
	private final static Integer DEFAULT_DUMMY_EXPERIENCE = 5;
	
	private final static String WEAPON_LOSE_DURABILITY_MSG = "Weapon don't lose durability!";
	
	private Weapon weapon;
	private Target target;
	
	@Before
	public void beforeTests() {
		weapon = new Axe(DEFAULT_AXE_ATACK, DEFAULT_AXE_DURABILITY);
		target = new Dummy(DEFAULT_DUMMY_HEALTH, DEFAULT_DUMMY_EXPERIENCE);
	}
	
	@Test
	public void weaponAttacksLosesDurability() {
		weapon.attack(target);
		Assert.assertEquals(WEAPON_LOSE_DURABILITY_MSG, (DEFAULT_AXE_DURABILITY - DEFAULT_AXE_DURABILITY_LOSE), weapon.getDurabilityPoints());
	}
	
	@Test(expected = IllegalStateException.class)
	public void brokenWeaponCantAtack() {
		weapon.attack(target);
		weapon.attack(target);
	}

}
