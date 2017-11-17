package p09_CollectionHierarchy.collections;

import java.util.ArrayDeque;

public abstract class BaseCollection {

	protected ArrayDeque<String> collection;

	protected BaseCollection() {
		this.collection = new ArrayDeque<>();
	}
	
}
