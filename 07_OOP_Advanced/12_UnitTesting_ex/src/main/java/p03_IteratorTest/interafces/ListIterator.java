package p03_IteratorTest.interafces;

import javax.naming.OperationNotSupportedException;

public interface ListIterator {
	
	Boolean hasNext();
	
	Boolean move();
	
	String print() throws OperationNotSupportedException;

}
