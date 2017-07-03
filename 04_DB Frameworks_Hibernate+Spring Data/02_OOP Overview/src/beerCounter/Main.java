package beerCounter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BeerCounter bc = new BeerCounter();
		
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split("\\s+");
		
		while(!input[0].equals("End")){
			bc.buyBeer(Integer.parseInt(input[0]));
			bc.drinkBeer(Integer.parseInt(input[1]));
			
			try { 
				input = scanner.nextLine().split("\\s+");
			} catch (Exception e) {
				break;
			}
		}
		scanner.close();
		
		System.out.printf("%d %d%n", BeerCounter.BEERS_IN_STOCK, BeerCounter.BEERS_DRANK_COUNT);

	}

}
