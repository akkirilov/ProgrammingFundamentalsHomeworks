package p09_CollectionHierarchy.collections.addRemoveCollections;

import p09_CollectionHierarchy.collections.BaseCollection;

public class AddRemoveCollectionImpl extends BaseCollection implements AddRemoveCollection {
	
	public AddRemoveCollectionImpl() {
		super();
	}
	
	@Override
	public String remove() {
		return super.collection.removeLast();
	}

	@Override
	public int add(String str) {
		super.collection.addFirst(str);
		return 0;
	}

}
