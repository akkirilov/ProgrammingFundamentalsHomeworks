import java.math.BigDecimal;
import java.util.Scanner;

public class lab04_EuroTrip {

	private final static Double PRICE_PER_KG = 1.2d;
	
	private final static BigDecimal EXCHANGE_RATE = new BigDecimal("4210500000000");
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Double quantity = scanner.nextDouble();
		
		BigDecimal result = new BigDecimal(quantity * PRICE_PER_KG).multiply(EXCHANGE_RATE);
		
		scanner.close();
		
		System.out.printf("%n%.2f marks%n", result);
		
	}

}
