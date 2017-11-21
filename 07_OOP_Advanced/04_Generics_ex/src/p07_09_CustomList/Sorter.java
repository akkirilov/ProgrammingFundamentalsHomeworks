package p07_09_CustomList;

import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
	
	public static <T extends Comparable<T>> void sort(CustomList<T> list) {
		List<T> sorted = list.getAsList().stream().sorted().collect(Collectors.toList());
		list.getAsList().clear();
		for (T t : sorted) {
			list.add(t);
		}
	}

}
