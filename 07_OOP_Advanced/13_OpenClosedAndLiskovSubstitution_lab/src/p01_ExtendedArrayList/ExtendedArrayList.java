package p01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {
	
	public T getMin() {
		Iterator<T> iterator = super.iterator();
		T min = null;
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (min == null || min.compareTo(next) > 0) {
				min = next;
			}
			
		}
		return min;
	}
	
	public T getMax() {
		Iterator<T> iterator = super.iterator();
		T max = null;
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (max == null || max.compareTo(next) < 0) {
				max = next;
			}
			
		}
		return max;
	}
	
}
