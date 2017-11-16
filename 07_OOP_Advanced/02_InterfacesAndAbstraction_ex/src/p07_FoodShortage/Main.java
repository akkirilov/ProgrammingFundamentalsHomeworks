package p07_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import p07_FoodShortage.buyers.Buyer;
import p07_FoodShortage.buyers.BuyerFactory;

public class Main {

	public static void main(String[] args) {
		
		List<Buyer> buyers = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String[] tokens = scanner.nextLine().split("\\s+");
			buyers.add(BuyerFactory.create(tokens));
		}
		
		String name = scanner.nextLine();
		while (!name.equals("End")) {
			for (Buyer b : buyers) {
				if (b.getName().equals(name)) {
					b.buyFood();
					break;
				}
			}
			name = scanner.nextLine();
		}
		
		scanner.close();

		int totalFood = 0;
		for (Buyer b : buyers) {
			totalFood += b.getFood();
		}
		
		System.out.println(totalFood);
	
	}

}
