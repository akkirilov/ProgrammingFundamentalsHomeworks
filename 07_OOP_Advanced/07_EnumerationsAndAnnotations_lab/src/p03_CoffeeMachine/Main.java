package p03_CoffeeMachine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();

		Scanner scanner = new Scanner(System.in);
		
		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equalsIgnoreCase("END")) {
			if (tokens.length == 1) {
				coffeeMachine.insertCoin(tokens[0]);
			} else {
				coffeeMachine.buyCoffee(tokens[0], tokens[1]);
			}
			
			tokens = scanner.nextLine().split("\\s+");
		}
		
		scanner.close();
		
		Iterable<Coffee> coffeesSold = coffeeMachine.coffeesSold();
		for (Coffee coffee : coffeesSold) {
			System.out.println(coffee);
		}

	}

}
