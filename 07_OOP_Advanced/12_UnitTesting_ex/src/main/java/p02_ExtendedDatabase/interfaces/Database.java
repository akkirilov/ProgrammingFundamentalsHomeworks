package p02_ExtendedDatabase.interfaces;

import javax.naming.OperationNotSupportedException;

public interface Database {
	
	void add(People people) throws OperationNotSupportedException;
	
	void remove() throws OperationNotSupportedException;
	
	People[] fetch();
	
	People findById(Long id) throws OperationNotSupportedException;
	
	People findByUsername(String username) throws OperationNotSupportedException;

}
