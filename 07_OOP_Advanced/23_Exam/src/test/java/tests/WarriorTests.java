package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.participants.Warrior;

public class WarriorTests {
	
//	Targetable targetable;
//	Targetable targetable2;
//	
//	@Before
//	public void initialization() {
//		this.targetable = new Warrior();
//		this.targetable2 = new Warrior();
////		targetable2 = Mockito.mock(Targetable.class);
////		Mockito.when(targetable.isAlive()).thenReturn(true);
////		Mockito.when(targetable2.isAlive()).thenReturn(true);
////		Mockito.when(targetable.getGold()).thenReturn(100.0);
////		Mockito.when(targetable2.getGold()).thenReturn(100.0);
////		Mockito.when(targetable.getHealth()).thenReturn(4.0);
////		Mockito.when(targetable2.getHealth()).thenReturn(4.0);
//////		Mockito.when(targetable2.takeDamage(2.0));
//////		Mockito.when(targetable.takeDamage(2.0)).thenReturn(targetable.getHealth() - 2.0);
////		Mockito.when(targetable.giveReward(targetable2)).thenReturn(2);
//	}
	
	@Test
	public void heroTests() {
//		takeDamage()
//		isAlive()
//		levelUp()
//		giveReward()
//		receiveReward()
		Hero targetable = new Warrior();
		Hero targetable2 = new Warrior();
		targetable.attack(targetable2);
		Assert.assertEquals(targetable2.getHealth() + "", 36.0 + "");
		targetable.attack(targetable2);
		Assert.assertEquals(targetable2.getHealth() + "", 22.0 + "");
		targetable.attack(targetable2);
		Assert.assertEquals(targetable2.getHealth() + "", 8.0 + "");
		targetable.attack(targetable2);
		Assert.assertFalse(targetable2.isAlive());
		Assert.assertEquals(targetable.getHealth() + "", 100.0 + "");
		Assert.assertEquals(targetable.getDexterity() + "", 8 + "");
		Assert.assertEquals(targetable.getIntelligence() + "", 2 + "");
		Assert.assertEquals(targetable.getStrength() + "", 10 + "");
//		targetable.receiveReward(200);
//		Assert.assertEquals(targetable.getGold() + "", 400.0 + "");
		Assert.assertTrue(targetable.isAlive());
	}
	

}
