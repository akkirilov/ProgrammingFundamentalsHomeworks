package p09_CollectionHierarchy.collections.myLists;

import p09_CollectionHierarchy.collections.BaseCollection;

public class MyListImpl extends BaseCollection implements MyList {

	public MyListImpl() {
		super();
	}
	
	@Override
	public String remove() {
		return super.collection.removeFirst();
	}

	@Override
	public int add(String str) {
		super.collection.addFirst(str);
		return 0;
	}

	@Override
	public int used() {
		return super.collection.size();
	}

}
