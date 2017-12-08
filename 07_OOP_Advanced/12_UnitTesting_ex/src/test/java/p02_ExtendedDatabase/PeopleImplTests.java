package p02_ExtendedDatabase;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import p02_ExtendedDatabase.interfaces.People;

public class PeopleImplTests {
	
	private final static Long ID = 1L;
	private final static String USERNAME = "Gosho";
	
	private final static String ERR_CONSTRUCTOR_MSG = "Constructor error!";
	private final static String ERR_USERNAME_MSG = "Can't get correct username!";
	private final static String ERR_ID_MSG = "Can't get correct id!";
	
	private People user;
	
	@Before
	public void initialization() {
		this.user = new PeopleImpl(ID, USERNAME);
	}
	
	@Test
	public void constructorTest() {
		Constructor<People> constructor = null;
		try {
			constructor = (Constructor<People>) user.getClass().getConstructor(Long.class, String.class);
		} catch (NoSuchMethodException | SecurityException e) {   }
		Assert.assertTrue(ERR_CONSTRUCTOR_MSG, constructor != null);
	}
	
	@Test
	public void usernameTest() {
		Assert.assertTrue(ERR_USERNAME_MSG, this.user.getUsername().equals(USERNAME));
	}
	
	@Test
	public void idTest() {
		Assert.assertTrue(ERR_ID_MSG, this.user.getId() == ID);
	}
	
}
