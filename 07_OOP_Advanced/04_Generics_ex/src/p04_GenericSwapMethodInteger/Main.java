package p04_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		List<Box> boxes = new ArrayList<>(); 
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			Box<Integer> box = new Box<Integer>(Integer.parseInt(scanner.nextLine()));
			boxes.add(box);
		}
		
		int indexOne = scanner.nextInt();
		int indexTwo = scanner.nextInt();
		scanner.close();
		
		ListUtils.swap(boxes, indexOne, indexTwo);
		for (Box<?> box : boxes) {
			System.out.println(box);
		}
	}

}
