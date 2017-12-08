package p03_IteratorTest;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import p03_IteratorTest.entities.ListIteratorImpl;
import p03_IteratorTest.interafces.ListIterator;

public class ListIteratorTests {
	
	private final static String STRING_ZERO = "create";
	private final static String STRING_ONE = "one";
	private final static String STRING_TWO = "two";
	private final static String STRING_THREE = "three";
	
	private final static String ERR_HAS_NEXT_MSG = "Error in hasNext method!";
	private static final String ERR_MOVE_MSG = "Error in move method!";
	private static final String ERR_PRINT_MSG = "Error in print method!";
	
	private ListIterator list;
	
	@Before
	public void initialization() {
		this.list = new ListIteratorImpl(STRING_ZERO, STRING_ONE, STRING_TWO, STRING_THREE);
	}
	
	@Test
	public void hasNextTrueTest() {
		Assert.assertTrue(ERR_HAS_NEXT_MSG, this.list.hasNext());
	}
	
	@Test
	public void hasNextFalseTest() {
		this.list.move();
		this.list.move();
		this.list.move();
		Assert.assertFalse(ERR_HAS_NEXT_MSG, this.list.hasNext());
	}
	
	@Test
	public void moveTrueTest() {
		Assert.assertTrue(ERR_MOVE_MSG, this.list.move());
	}
	
	@Test
	public void moveFalseTest() {
		this.list.move();
		this.list.move();
		this.list.move();
		Assert.assertFalse(ERR_MOVE_MSG, this.list.move());
	}
	
	@Test
	public void printTest() throws OperationNotSupportedException {
		this.list.move();
		String fetchString = this.list.print();
		Assert.assertTrue(ERR_PRINT_MSG, fetchString.equals(STRING_TWO));
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void printExceptionTest() throws OperationNotSupportedException {
		ListIterator emptyList = new ListIteratorImpl();
		emptyList.print();
	}

}
