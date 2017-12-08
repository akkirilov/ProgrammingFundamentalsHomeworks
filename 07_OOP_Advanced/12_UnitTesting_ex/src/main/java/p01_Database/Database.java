package p01_Database;

import javax.naming.OperationNotSupportedException;

public interface Database {
	
	void add(Integer num) throws OperationNotSupportedException;
	
	void remove() throws OperationNotSupportedException;
	
	Integer[] fetch();

}
