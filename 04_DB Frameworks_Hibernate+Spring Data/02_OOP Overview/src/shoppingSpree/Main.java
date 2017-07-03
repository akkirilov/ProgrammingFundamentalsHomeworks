package shoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Set<Person> persons = new LinkedHashSet<>();
		String[] inputPersons = Arrays.stream(scanner.nextLine().split(";"))
				.filter(x -> !x.equals(""))
				.toArray(String[]::new);
		for (int i = 0; i < inputPersons.length; i++) {
			String[] info = inputPersons[i].split("=");
			if(info[0].trim().equals("")) {
				System.out.println("Name cannot be empty");
				scanner.close();
				return;
			} else if (Double.parseDouble(info[1]) < 0) {
				System.out.println("Money cannot be negative");
				scanner.close();
				return;
			} else {
				persons.add(new Person(info[0], Double.parseDouble(info[1])));
			}
		}
		
		Set<Product> products = new LinkedHashSet<>();
		String[] inputProducts = Arrays.stream(scanner.nextLine().split(";"))
				.filter(x -> !x.equals(""))
				.toArray(String[]::new);
		for (int i = 0; i < inputProducts.length; i++) {
			String[] info = inputProducts[i].split("=");
			if(info[0].trim().equals("")) {
				System.out.println("Name cannot be empty");
				scanner.close();
				return;
			} else if (Double.parseDouble(info[1]) < 0) {
				System.out.println("Money cannot be negative");
				scanner.close();
				return;
			} else {
				products.add(new Product(info[0], Double.parseDouble(info[1])));
			}
		}
				
		String[] action = scanner.nextLine().split("\\s+");
		while (!action[0].equals("END")) {
			for (Person person : persons) {
				if (person.getName().equals(action[0])) {
					for (Product product : products) {
						if (product.getName().equals(action[1])) {
							person.addProduct(product);
							break;
						}
					}
					break;
				}
			}
			
			action = scanner.nextLine().split("\\s+");
		}
		scanner.close();
		
		for (Person person : persons) {
			person.printProducts();
		}
		
	}

}
