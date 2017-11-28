package p03_StackIterator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		Integer[] toInsert = new Integer[tokens.length - 1];
		
		if (tokens[0].equals("Push")) {
			for (int i = 1; i < tokens.length; i++) {
				toInsert[i - 1] = Integer.parseInt(tokens[i].replace(",", ""));
			}
		}
		
		IntStack intStack = new IntStack(toInsert);
		
		tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("END")) {

			switch (tokens[0]) {
			
			case "Pop":
				intStack.pop();
				break;
			case "Push":
				Integer[] toPush = new Integer[tokens.length - 1];
				for (int i = 1; i < tokens.length; i++) {
					toPush[i - 1] = Integer.parseInt(tokens[i].replace(",", ""));
				}
				intStack.push(toPush);
				break;
			default:
				break;
			}
			
			tokens = scanner.nextLine().split("\\s+");
		}
		
		scanner.close();

		intStack.printTwice();

	}

}
