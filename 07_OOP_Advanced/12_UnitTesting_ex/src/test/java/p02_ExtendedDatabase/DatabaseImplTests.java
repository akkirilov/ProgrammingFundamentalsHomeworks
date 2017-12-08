package p02_ExtendedDatabase;

import java.lang.reflect.Constructor;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import p02_ExtendedDatabase.interfaces.Database;
import p02_ExtendedDatabase.interfaces.People;

public class DatabaseImplTests {

	private final static Integer DEFAULT_DATABASE_CAPACITY = 16;
	private final static Long WRONG_ID = Long.valueOf(DEFAULT_DATABASE_CAPACITY) + 10L;
	private final static String WRONG_USERNAME = "hjsbhjbsdsbdb";
	private final static Long ID_ONE = 1L;
	private final static String USERNAME_ONE = "Pesho";
	private final static Long ID_TWO = 2L;
	private final static String USERNAME_TWO = "Gosho";
	private final static Long DEFAULT_ID = 0L;
	private final static String DEFAULT_USERNAME = "Stamat";
	
	private final static String ERR_CONSTRUCTOR_MSG = "Constructor error!";
	private final static String ERR_ADD_NUM_MSG = "Incorect adding!";
	private final static String ERR_FETCH_MSG = "Incorect fetching!";
	private final static String ERR_GET_BY_ID_MSG = "Incorect fetching by id!";
	private static final String ERR_GET_BY_USERNAME_MSG = "Incorect fetching by username!";
	private final static String ERR_DEFAULT_CAPACITY_MSG = "Incorect database capacity!";
	
	private People user;
	private Database database;

	@Before
	public void initialization() {
		user = new PeopleImpl(DEFAULT_ID, DEFAULT_USERNAME);
		this.database = new DatabaseImpl(user);
	}

	@Test
	public void constructorTest() {
		Constructor<DatabaseImpl> constructor = null;
		try {
			constructor = (Constructor<DatabaseImpl>) this.database.getClass().getConstructor(People[].class);
		} catch (NoSuchMethodException | SecurityException e) {   }
		Assert.assertTrue(ERR_CONSTRUCTOR_MSG, constructor != null);
	}

	@Test
	public void addPeopleTest() throws OperationNotSupportedException {
		People userToAdd = new PeopleImpl(ID_ONE, USERNAME_ONE);
		this.database.add(userToAdd);
		People fetchUser = null;
		fetchUser = this.database.findById(userToAdd.getId());
		Assert.assertTrue(ERR_ADD_NUM_MSG, fetchUser != null);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addNullTest() throws OperationNotSupportedException {
		this.database.add(null);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addWithExistingIdTest() throws OperationNotSupportedException {
		this.database.add(new PeopleImpl(DEFAULT_ID, USERNAME_TWO));
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addWithExistingUsernameTest() throws OperationNotSupportedException {
		this.database.add(new PeopleImpl(ID_TWO, DEFAULT_USERNAME));
	}

	@Test(expected = OperationNotSupportedException.class)
	public void addMoreThanCapacityTest() throws OperationNotSupportedException {
		for (int i = 0; i < 17; i++) {
			this.database.add(new PeopleImpl(Long.valueOf(i), "username" + i));
		}
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void removeFromEmptyDatabaseTest() throws OperationNotSupportedException {
		for (int i = 0; i < 17; i++) {
			this.database.remove();
		}
	}
	
	@Test
	public void fetchTest() {
		People[] arr = null;
		arr = this.database.fetch();
		Assert.assertTrue(ERR_FETCH_MSG, arr != null);
	}
	
	@Test
	public void databaseSizeTests() {
		People[] arr = this.database.fetch();
		Assert.assertTrue(ERR_DEFAULT_CAPACITY_MSG, arr.length == DEFAULT_DATABASE_CAPACITY);
	}
	
	@Test
	public void findByIdTest() throws OperationNotSupportedException  {
		People fetchUser = this.database.findById(this.user.getId());
		Assert.assertTrue(ERR_GET_BY_ID_MSG, fetchUser.getUsername().equals(this.user.getUsername()) 
				&& fetchUser.getId() == this.user.getId());
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void findByNonExistingIdTest() throws OperationNotSupportedException  {
		this.database.findById(WRONG_ID);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void findByIdFromEmptyDatabaseTest() throws OperationNotSupportedException  {
		this.database.remove();
		this.database.findById(this.user.getId());
	}
	
	@Test
	public void findByUsernameTest() throws OperationNotSupportedException  {
		People fetchUser = this.database.findByUsername(this.user.getUsername());
		Assert.assertTrue(ERR_GET_BY_USERNAME_MSG, fetchUser.getUsername().equals(this.user.getUsername()) 
				&& fetchUser.getId() == this.user.getId());
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void findByNonExistingUsernameTest() throws OperationNotSupportedException {
		this.database.findByUsername(WRONG_USERNAME);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void findByUsernameFromEmptyDatabaseTest() throws OperationNotSupportedException  {
		this.database.remove();
		this.database.findByUsername(this.user.getUsername());
	}

}
