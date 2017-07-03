package beerCounter;

public class BeerCounter {

	public static int BEERS_DRANK_COUNT = 0;
	public static int BEERS_IN_STOCK = 0;
	
	public BeerCounter() {
		
	}

	public void buyBeer(int beers) {
		BEERS_IN_STOCK += beers;
	}

	public void drinkBeer(int beers) {
		BEERS_IN_STOCK -= beers;
		BEERS_DRANK_COUNT += beers;
	}

	public static int getBEERS_DRANK_COUNT(){
		return BEERS_DRANK_COUNT;
	}
	
	public static int getBEERS_IN_STOCK(){
		return BEERS_IN_STOCK;
	}
}
