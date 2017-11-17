package p09_CollectionHierarchy.collections.addCollections;

import p09_CollectionHierarchy.collections.BaseCollection;

public class AddCollectionImpl extends BaseCollection implements AddCollection {

	public AddCollectionImpl() {
		super();
	}

	@Override
	public int add(String str) {
		super.collection.addLast(str);
		return super.collection.size() - 1;
	}
	
}
