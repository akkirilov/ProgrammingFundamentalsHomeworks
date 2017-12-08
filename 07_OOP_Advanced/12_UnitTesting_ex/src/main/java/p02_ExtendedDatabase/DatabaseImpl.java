package p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;

import p02_ExtendedDatabase.interfaces.Database;
import p02_ExtendedDatabase.interfaces.People;

public class DatabaseImpl implements Database {

	private final static Integer DATABASE_CAPACITY = 16;
	private static Integer NEXT_INDEX = 0;
	
	private People[] database;

	public DatabaseImpl(People... initialNumbers) {
		this.setDatabase(initialNumbers);
	}

	private void setDatabase(People[] initPeople) {
		this.database = new People[DATABASE_CAPACITY];
		for (int i = 0; i < initPeople.length; i++) {
			this.database[i] = initPeople[i];
			NEXT_INDEX = i + 1;
		}
	}

	public void add(People people) throws OperationNotSupportedException {
		if (people == null) {
			throw new OperationNotSupportedException("People can't be null!");
		}
		if (NEXT_INDEX >= DATABASE_CAPACITY) {
			throw new OperationNotSupportedException("Databse is full!");
		}
		if (this.containsId(people.getId())) {
			throw new OperationNotSupportedException("There are user with this id");
		}
		if (this.containsUsername(people.getUsername())) {
			throw new OperationNotSupportedException("There are user with this id");
		}
		this.database[NEXT_INDEX] = people;
		NEXT_INDEX++;
	}

	private boolean containsUsername(String username) {
		for (int i = 0; i < this.database.length; i++) {
			if (this.database[i] != null && this.database[i].getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsId(Long id) {
		for (int i = 0; i < this.database.length; i++) {
			if (this.database[i] != null && this.database[i].getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void remove() throws OperationNotSupportedException {
		if (NEXT_INDEX <= 0) {
			throw new OperationNotSupportedException("Databse is empty!");
		}
		NEXT_INDEX--;
		this.database[NEXT_INDEX] = null;
	}

	public People[] fetch() {
		return this.database;
	}

	@Override
	public People findById(Long id) throws OperationNotSupportedException {
		if (NEXT_INDEX <= 0) {
			throw new OperationNotSupportedException("Databse is empty!");
		}
		for (int i = 0; i < this.database.length; i++) {
			if (this.database[i] != null && this.database[i].getId() == id) {
				return this.database[i];
			}
		}
		throw new OperationNotSupportedException("There are no such user!");
	}

	@Override
	public People findByUsername(String username) throws OperationNotSupportedException {
		if (NEXT_INDEX <= 0) {
			throw new OperationNotSupportedException("Databse is empty!");
		}
		for (int i = 0; i < this.database.length; i++) {
			if (this.database[i] != null && this.database[i].getUsername().equals(username)) {
				return this.database[i];
			}
		}
		throw new OperationNotSupportedException("There are no such user!");
	}
	
}
