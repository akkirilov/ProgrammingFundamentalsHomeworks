package p06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p06_GenericCountMethodDouble.Box;
import p06_GenericCountMethodDouble.ListUtils;

public class Main {

	public static void main(String[] args) {

		List<Box<Double>> boxes = new ArrayList<>(); 
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			Box<Double> box = new Box<Double>(Double.parseDouble(scanner.nextLine()));
			boxes.add(box);
		}
		
		Double ell = Double.parseDouble(scanner.nextLine());
		
		scanner.close();

		int result = ListUtils.countGreaterEllements(boxes, ell);
		System.out.println(result);
		
	}

}
