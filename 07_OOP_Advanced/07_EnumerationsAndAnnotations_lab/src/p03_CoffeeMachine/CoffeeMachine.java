package p03_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
	
	private List<Coffee> coffeesSold;
	private List<Coin> coins;
	
	
	public CoffeeMachine() {
		this.coffeesSold = new ArrayList<>();
		this.coins = new ArrayList<>();
	}

	public void buyCoffee(String size, String type) {
		Integer sumOfCoins = 0;
		for (Coin c : coins) {
			sumOfCoins += c.getValue();
		}
		
		CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
		if (coffeeSize.getPrice() <= sumOfCoins) {
			CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());
			Coffee coffee = new Coffee(coffeeSize, coffeeType);
			coffeesSold.add(coffee);
			coins.clear();
		}
	}
	
	public void insertCoin(String coin) {
		this.coins.add(Coin.valueOf(coin.toUpperCase()));
	}
	
	public Iterable<Coffee> coffeesSold() {
		return this.coffeesSold;
	}

}
