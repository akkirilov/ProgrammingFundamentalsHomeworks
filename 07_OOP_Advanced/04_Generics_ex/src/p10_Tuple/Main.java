package p10_Tuple;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");
		Tuple<String, String> tuple1 = new Tuple<>(tokens[0] + " " + tokens[1], tokens[2]);
		
		tokens = scanner.nextLine().split("\\s+");
		Tuple<String, Integer> tuple2 = new Tuple<>(tokens[0], Integer.parseInt(tokens[1]));
		
		tokens = scanner.nextLine().split("\\s+");
		Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]));
		
		System.out.println(tuple1);
		System.out.println(tuple2);
		System.out.println(tuple3);
		
		scanner.close();

	}

}
