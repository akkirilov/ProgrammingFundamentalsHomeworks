package tests;

import org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.contracts.Targetable;
import app.models.participants.Warrior;

public class WarriorTests {
	
	private final static double DAMAGE = 2.0;
	
	
	
//	@Before
//	public void initialization() {
//		this.targetable = new Warrior();
//		this.targetable2 = new Warrior();
////		this.targetable2 = new Warrior();
////		targetable2 = Mockito.mock(Targetable.class);
////		Mockito.when(targetable.isAlive()).thenReturn(true);
////		Mockito.when(targetable2.isAlive()).thenReturn(true);
////		Mockito.when(targetable.getGold()).thenReturn(5.0);
////		Mockito.when(targetable2.getGold()).thenReturn(100.0);
////		Mockito.when(targetable.getHealth()).thenReturn(4.0);
////		Mockito.when(targetable2.getHealth()).thenReturn(4.0);
//////		Mockito.when(targetable2.takeDamage(2.0));
//////		Mockito.when(targetable.takeDamage(2.0)).thenReturn(targetable.getHealth() - 2.0);
////		Mockito.when(targetable.giveReward(targetable2)).thenReturn(2);
//	}
	
	@Test
	public void isAliveTest() {
		Targetable targetable = new Warrior();
		Targetable targetable2 = new Warrior();
		targetable.attack(targetable2);
		Assert.assertEquals(targetable2.getHealth() + "", 14.0 + "");
		targetable.attack(targetable2);
		Assert.assertEquals(targetable.getHealth() + "", 50.0 + "");
		Assert.assertTrue(targetable.isAlive());
	}
	
	
//	@Test
//	public void damageTest() {
//		
//	}
	
//	@Test
//	public void giveRewardTest() {
//		Assert.assertTrue(this.targetable.isAlive());
//	}

}
