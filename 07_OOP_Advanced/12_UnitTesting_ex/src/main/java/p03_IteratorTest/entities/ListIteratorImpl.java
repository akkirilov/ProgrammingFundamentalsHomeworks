package p03_IteratorTest.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import p03_IteratorTest.interafces.ListIterator;

public class ListIteratorImpl implements ListIterator {
	
	private Integer ITERATOR = 0;

	private List<String> list;

	public ListIteratorImpl(String... strings) {
		this.setLists(strings);
	}

	private void setLists(String[] strings) {
		this.list = new ArrayList<>(Arrays.asList(strings));
		if (this.list.size() > 0) {
			this.list.remove(0);
		}
	}

	@Override
	public Boolean hasNext() {
		if (ITERATOR < this.list.size() - 1) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean move() {
		if (this.hasNext()) {
			ITERATOR++;
			return true;
		}
		return false;
	}

	@Override
	public String print() throws OperationNotSupportedException {
		if (this.list.size() == 0) {
			throw new OperationNotSupportedException("Invalid Operation!");
		} else {
			return this.list.get(ITERATOR);
		} 
	}

}
