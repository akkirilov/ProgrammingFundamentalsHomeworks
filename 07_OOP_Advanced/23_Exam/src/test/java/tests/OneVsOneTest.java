package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;

public class OneVsOneTest {
	
	@Test
	public void testError() {
		List<Targetable> targetables = new ArrayList<>();
		targetables.add(new Warrior());
		targetables.add(new Warrior());
		targetables.add(new Warrior());
		OneVsOne one = new OneVsOne();
		
		Assert.assertEquals(one.executeAction(targetables), "There should be exactly 2 participants for OneVsOne!");
		
	}
	@Test
	public void testErrorWithOne() {
		List<Targetable> targetables = new ArrayList<>();
		targetables.add(new Warrior());
		OneVsOne one = new OneVsOne();
		
		Assert.assertEquals(one.executeAction(targetables), "There should be exactly 2 participants for OneVsOne!");
		
	}
	
//	@Test
//	public void testAlive() {
//		Hero targetable = new Warrior();
//		Hero targetable2 = new Warrior();
//		List<Targetable> targetables = new ArrayList<>();
//		targetables.add(targetable);
//		targetables.add(targetable2);
//		OneVsOne one = new OneVsOne();
//		one.executeAction(targetables);
//		Assert.assertTrue(targetable.g());
////		Assert.assertFalse(targetable2.isAlive());
////		Assert.assertEquals(one.executeAction(targetables), "There should be exactly 2 participants for OneVsOne!");
//		
//	}
	
	@Test(expected = NullPointerException.class)
	public void testIfNull() {
		List<Targetable> targetables = null;
		OneVsOne one = new OneVsOne();
		
		Assert.assertEquals(one.executeAction(targetables), "There should be exactly 2 participants for OneVsOne!");
		
	}

}
