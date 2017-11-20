package p04_07_ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 1, 2, 3, 4, 5);
		
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, 11, 12, 13, 14, 15);
		
		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2, 21, 22, 23, 24, 25);
		
		List<Integer> listNulls = new ArrayList<>();
		Collections.addAll(listNulls, 1, 2, null, 4, 5);

		List<List<Integer>> listOfLists = new ArrayList<>();
		listOfLists.add(list);
		listOfLists.add(list1);
		listOfLists.add(list2);
		
		List<Integer> listFlat = new ArrayList<>();
		ListUtils.flatten(listFlat, listOfLists);

		List<Integer> listAll = new ArrayList<>();
		ListUtils.addAll(listAll, list1);
		
		System.out.println("Min: " + ListUtils.getMin(list));
		System.out.println("Max: " + ListUtils.getMax(list));
		System.out.println("Nulls: " + ListUtils.getNullIndices(listNulls));
		System.out.println("Flatten: " + listFlat);
		System.out.println("AddAll: " + listAll);
		
	}

}
