package p01_ExtendedArrayList;

import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		
		ExtendedArrayList<Integer> ints = new ExtendedArrayList<>();
		Collections.addAll(ints, 0, 1, 2, 3, 4, 5);
		
		System.out.println("Values: " + ints.toString());
		System.out.println("Min: " + ints.getMin());
		System.out.println("Max: " + ints.getMax());
		
	}

}
