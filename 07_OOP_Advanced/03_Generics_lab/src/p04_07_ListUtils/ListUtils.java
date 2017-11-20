package p04_07_ListUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T extends Comparable<T>> {

	public static <T extends Comparable<T>> T getMin(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		T min = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (min.compareTo(list.get(i)) > 0) {
				min = list.get(i);
			}
		}
		
		return min;
	}
	
	public static <T extends Comparable<T>> T getMax(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		T max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (max.compareTo(list.get(i)) < 0) {
				max = list.get(i);
			}
		}
		
		return max;
	}
	
	public static <T> List<Integer> getNullIndices(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		List<Integer> nullIndices = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				nullIndices.add(i);
			}
		}
		
		return nullIndices;
	}
	
	public static <T> void flatten(List<T> destination, List<List<T>> source) {
		for (List<T> list : source) {
			destination.addAll(list);
		}
	}
	
	public static <T> void addAll(List<T> destination, List<T> source) {
		destination.addAll(source);
	}
	
}
