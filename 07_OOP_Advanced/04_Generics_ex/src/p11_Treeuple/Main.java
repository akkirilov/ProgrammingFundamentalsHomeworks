package p11_Treeuple;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");
		Treeuple<String, String, String> tuple1 = new Treeuple<>(tokens[0] + " " + tokens[1], tokens[2], tokens[3]);
		
		tokens = scanner.nextLine().split("\\s+");
		Treeuple<String, Long, Boolean> tuple2 = new Treeuple<>(tokens[0], Long.parseLong(tokens[1]), !tokens[2].equalsIgnoreCase("drunk") ? false : true);
		
		tokens = scanner.nextLine().split("\\s+");
		Treeuple<String, Double, String> tuple3 = new Treeuple<>(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
		
		System.out.println(tuple1);
		System.out.println(tuple2);
		System.out.println(tuple3);
		
		scanner.close();

	}

}
