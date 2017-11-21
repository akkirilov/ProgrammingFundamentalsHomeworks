package p05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p05_GenericCountMethodString.Box;
import p05_GenericCountMethodString.ListUtils;

public class Main {

	public static void main(String[] args) {

		List<Box<String>> boxes = new ArrayList<>(); 
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			Box<String> box = new Box<String>(scanner.nextLine());
			boxes.add(box);
		}
		
		String ell = scanner.nextLine();
		
		scanner.close();

		int result = ListUtils.countGreaterEllements(boxes, ell);
		System.out.println(result);
		
	}

}
