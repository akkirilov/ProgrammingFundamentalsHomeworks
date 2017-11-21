package p07_09_CustomList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		CustomList<String> list = new CustomList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		while (!input.equals("END")) {
			String[] tokens = input.split("\\s+");
			
			switch (tokens[0]) {
			case "Add":
				list.add(tokens[1]);
				break;
			case "Remove":
				list.remove(Integer.parseInt(tokens[1]));
				break;
			case "Contains":
				System.out.println(list.contains(tokens[1]));
				break;
			case "Swap":
				list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				break;
			case "Greater":
				System.out.println(list.countGreaterThan(tokens[1]));
				break;
			case "Max":
				System.out.println(list.getMax());
				break;
			case "Min":
				System.out.println(list.getMin());
				break;
			case "Sort":
				Sorter.sort(list);
				break;
			case "Print":
				for (String ell : list) {
					System.out.println(ell);
				}
				break;
			default:
				break;
			}
			
			input = scanner.nextLine();
		}
		
		scanner.close();

	}

}
