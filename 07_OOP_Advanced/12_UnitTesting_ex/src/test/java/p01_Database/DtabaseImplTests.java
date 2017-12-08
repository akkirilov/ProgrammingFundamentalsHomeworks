package p01_Database;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DtabaseImplTests {

	private final static Integer ZERO = 0;
	private final static Integer ONE = 1;
	private final static Integer TWO = 2;
	private final static Integer NUM_TO_ADD = 3;
	private final static Integer DEFAULT_DATABASE_CAPACITY = 16;
	
	private final static String ERR_CONSTRUCTOR_MSG = "Constructor error!";
	private final static String ERR_ADD_NUM_MSG = "Incorect num adding!";
	private final static String ERR_FETCH_MSG = "Incorect fetching!";
	private final static String ERR_DEFAULT_CAPACITY_MSG = "Incorect database capacity!";
	
	private Database database;

	@Before
	public void initialization() {
		this.database = new DatabaseImpl(ZERO, ONE, TWO);
	}

	@Test
	public void constructorTest() {
		Constructor<DatabaseImpl> constructor = null;
		try {
			constructor = (Constructor<DatabaseImpl>) this.database.getClass().getConstructor(Integer[].class);
		} catch (NoSuchMethodException | SecurityException e) {   }
		Assert.assertTrue(ERR_CONSTRUCTOR_MSG, constructor != null);
	}

	@Test
	public void addNumTest() throws OperationNotSupportedException {
		this.database.add(NUM_TO_ADD);
		Integer[] arr = this.database.fetch();
		int sum = Arrays.stream(arr).filter(x -> x != null).mapToInt(Integer::valueOf).sum()
				- (ZERO + ONE + TWO + NUM_TO_ADD);
		Assert.assertTrue(ERR_ADD_NUM_MSG, sum == 0);
	}
	
	@Test(expected = OperationNotSupportedException.class)
	public void addNullTest() throws OperationNotSupportedException {
		this.database.add(null);
	}

	@Test(expected = OperationNotSupportedException.class)
	public void addMoreThanCapacityTest() throws OperationNotSupportedException {
		for (int i = 0; i < 17; i++) {
			this.database.add(i);
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
		Integer[] arr = null;
		arr = this.database.fetch();
		Assert.assertTrue(ERR_FETCH_MSG, arr != null);
	}
	
	@Test
	public void databaseSizeTests() {
		Integer[] arr = this.database.fetch();
		Assert.assertTrue(ERR_DEFAULT_CAPACITY_MSG, arr.length == DEFAULT_DATABASE_CAPACITY);
	}

}
