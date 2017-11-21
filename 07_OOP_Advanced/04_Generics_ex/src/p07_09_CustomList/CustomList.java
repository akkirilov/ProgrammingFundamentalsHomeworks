package p07_09_CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

	private List<T> list;

	public CustomList() {
		this.list = new ArrayList<>();
	}

	public void add(T element) {
		this.list.add(element);
	}

	public T remove(int index) {
		return this.list.remove(index);
	}

	public boolean contains(T element) {
		return this.list.contains(element);
	}

	public void swap(int indexOne, int indexTwo) {
		T one = this.list.get(indexOne);

		this.list.add(indexOne + 1, this.list.get(indexTwo));
		this.list.remove(indexOne);
		this.list.add(indexTwo + 1, one);
		this.list.remove(indexTwo);
	}

	public int countGreaterThan(T element) {
		int counter = 0;
		for (T ell : this.list) {
			if (ell.compareTo(element) > 0) {
				counter++;
			}
		}
		return counter;
	}

	public T getMax() {
		if (this.list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		T max = this.list.get(0);
		for (int i = 1; i < this.list.size(); i++) {
			if (max.compareTo(this.list.get(i)) < 0) {
				max = this.list.get(i);
			}
		}
		
		return max;
	}

	public T getMin() {
		if (this.list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		T min = this.list.get(0);
		for (int i = 1; i < this.list.size(); i++) {
			if (min.compareTo(this.list.get(i)) > 0) {
				min = this.list.get(i);
			}
		}
		
		return min;
	}

	public List<T> getAsList() {
		return this.list;
	}

	@Override
	public Iterator<T> iterator() {
		return this.list.iterator();
	}
	
}
