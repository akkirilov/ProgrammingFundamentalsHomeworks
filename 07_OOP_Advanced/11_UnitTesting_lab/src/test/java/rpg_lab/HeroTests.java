package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import interfaces.Target;
import interfaces.Weapon;

public class HeroTests {
	
	private final static Integer DEFAULT_TARGET_EXPERIENCE = 1000;
	private final static String DEAD_DUMMY_GIVE_EXPERIENCE_MSG = "Dead dummy don't give experience!";
	
	@Test
	public void attackGainsExperienceIfTargetIsDead() {
		Target target =  new Target() {
			public void takeAttack(int attackPoints) {
			}
			public boolean isDead() {
				return true;
			}
			public int giveExperience() {
				return DEFAULT_TARGET_EXPERIENCE;
			}
			public int getHealth() {
				return 0;
			}
		};
		
		Weapon weapon = new Weapon() {
			public int getDurabilityPoints() {
				return 0;
			}
			public int getAttackPoints() {
				return 0;
			}
			public void attack(Target target) {
				
			}
		};
		
		Hero hero = new Hero("Doichin", weapon);
		hero.attack(target);
		
		int expectedHeroExperience = (hero.getExperience() - target.giveExperience()) + target.giveExperience();
		
		Assert.assertEquals(DEAD_DUMMY_GIVE_EXPERIENCE_MSG, expectedHeroExperience, hero.getExperience());
	}
	
	@Test
	public void attackGainsExperienceIfMoockTargetIsDead() {
		Target targetMock = Mockito.mock(Target.class);
		Mockito.when(targetMock.giveExperience()).thenReturn(DEFAULT_TARGET_EXPERIENCE);
		Mockito.when(targetMock.isDead()).thenReturn(true);
				
		Weapon weaponMock = Mockito.mock(Weapon.class);
		
		Hero hero = new Hero("Doichin", weaponMock);
		hero.attack(targetMock);
		
		int expectedHeroExperience = (hero.getExperience() - targetMock.giveExperience()) + targetMock.giveExperience();
		
		Assert.assertEquals(DEAD_DUMMY_GIVE_EXPERIENCE_MSG, expectedHeroExperience, hero.getExperience());
	}

}
