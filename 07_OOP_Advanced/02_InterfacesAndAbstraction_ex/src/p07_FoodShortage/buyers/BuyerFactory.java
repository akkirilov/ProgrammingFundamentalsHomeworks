package p07_FoodShortage.buyers;

public class BuyerFactory {

	public static Buyer create(String[] tokens) {
		if (tokens.length == 4) {
			return new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
		} else {
			return new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
		}
	}
	
}
