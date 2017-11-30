package p03_CoffeeMachine;

public class Coffee {
	
	private CoffeeSize coffeeSize;
	private CoffeeType coffeeType;
	
	public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
		this.coffeeSize = coffeeSize;
		this.coffeeType = coffeeType;
	}

	@Override
	public String toString() {
		return coffeeSize.name().charAt(0) + coffeeSize.name().substring(1).toLowerCase() + " " 
				+ coffeeType.name().charAt(0) + coffeeType.name().substring(1).toLowerCase();
	}

}
