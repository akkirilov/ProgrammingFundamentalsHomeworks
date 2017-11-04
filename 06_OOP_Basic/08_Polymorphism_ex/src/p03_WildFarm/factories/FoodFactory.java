package p03_WildFarm.factories;

import p03_WildFarm.food.*;

public class FoodFactory {
	
	public static Food create(String[] tokens) {
	
		String foodType = tokens[0];
		Integer quantity = Integer.parseInt(tokens[1]);
		
		switch (foodType.toLowerCase()) {
		case "vegetable":
			return new Vegetable(quantity);
		case "meat":
			return new Meat(quantity);
		default:
			return null;
		}
		
	}

}
