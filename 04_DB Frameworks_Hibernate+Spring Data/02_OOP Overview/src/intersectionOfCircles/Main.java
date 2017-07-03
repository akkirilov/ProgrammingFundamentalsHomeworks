package intersectionOfCircles;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] income1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int[] income2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		scanner.close();
		
		Point p1 = new Point(income1[0], income1[1], income1[2]);
		Point p2 = new Point(income2[0], income2[1], income2[2]);
		
		if (Point.isIntersect(p1, p2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
