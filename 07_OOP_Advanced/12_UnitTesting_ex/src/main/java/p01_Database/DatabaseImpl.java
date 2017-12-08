package p01_Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseImpl implements Database {

	private final static Integer DATABASE_CAPACITY = 16;
	private static Integer NEXT_INDEX = 0;
	
	private Integer[] database;

	public DatabaseImpl(Integer... initialNumbers) {
		this.setDatabase(initialNumbers);
	}

	private void setDatabase(Integer[] initialNumbers) {
		this.database = new Integer[DATABASE_CAPACITY];
		for (int i = 0; i < initialNumbers.length; i++) {
			this.database[i] = initialNumbers[i];
			NEXT_INDEX = i + 1;
		}
	}

	public void add(Integer num) throws OperationNotSupportedException {
		if (num == null) {
			throw new OperationNotSupportedException("Number can't be null!");
		}
		if (NEXT_INDEX >= DATABASE_CAPACITY) {
			throw new OperationNotSupportedException("Databse is full!");
		}
		this.database[NEXT_INDEX] = num;
		NEXT_INDEX++;
	}

	public void remove() throws OperationNotSupportedException {
		if (NEXT_INDEX <= 0) {
			throw new OperationNotSupportedException("Databse is full!");
		}
		NEXT_INDEX--;
		this.database[NEXT_INDEX] = null;
	}

	public Integer[] fetch() {
		return this.database;
	}
	
}
