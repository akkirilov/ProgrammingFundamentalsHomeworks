import java.util.Scanner;

public class lab06_TransportPrice {

	private final static Double INITIAL_TAXI_TAX = 0.7d;
	private final static Double DAYTIME_TAXI_PER_KM = 0.79d;
	private final static Double NIGHTIME_TAXY_PER_KM = 0.9d;
	
	private final static Double BUS_TAX = 0.09d;
	
	private final static Double TRAIN_TAX = 0.06d;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		
		Double distance = scanner.nextDouble();
		String partOfDay = scanner.next();
		
		Double totalSum = 0.0d;
		if (distance < 20) {
			totalSum += INITIAL_TAXI_TAX;
			if (partOfDay.equals("night")) {
				totalSum += (distance * NIGHTIME_TAXY_PER_KM);
			} else {
				totalSum += (distance * DAYTIME_TAXI_PER_KM);
			}
		} else if (distance < 100) {
			totalSum += (distance * BUS_TAX); 
		} else {
			totalSum += (distance * TRAIN_TAX);
		}
		
		scanner.close();
		
		System.out.printf("%n%.2f%n", totalSum);
		
	}

}
