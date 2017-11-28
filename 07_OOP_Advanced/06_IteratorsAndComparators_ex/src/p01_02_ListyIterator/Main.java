package p01_02_ListyIterator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		String[] toInsert = null;
		
		if (tokens[0].equals("Create")) {
			toInsert = new String[tokens.length - 1];
			for (int i = 1; i < tokens.length; i++) {
				toInsert[i - 1] = tokens[i];
			}
		}
		
		ListyIterator listyIterator = new ListyIterator(toInsert);
		
		String command = scanner.nextLine();
		while (!command.equals("END")) {

			switch (command) {
			case "Move":
				System.out.println(listyIterator.move());
				break;
			case "HasNext":
				System.out.println(listyIterator.hasNext());
				break;
			case "Print":
				listyIterator.print();
				break;
			case "PrintAll":
				listyIterator.printAll();
				break;
			default:
				break;
			}
			
			command = scanner.nextLine();
		}
		
		scanner.close();

	}

}
