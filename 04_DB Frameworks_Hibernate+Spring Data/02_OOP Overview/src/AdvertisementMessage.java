import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		String[] phrases = new String[]{
				"Excellent product.", 
				"Such a great product.", 
				"I always use that product.", 
				"Best product of itscategory.", 
				"Exceptional product.", 
				"I can’t live without this product." };
		String[] events = new String[]{
				"Now I feel good.", 
				"I have succeeded with this product.", 
				"Makes miracles. I am happy of theresults!", 
				"I cannot believe but now I feel awesome.", 
				"Try it yourself, I am very satisfied.", 
				"I feel great!" };
		String[] authors = new String[]{
				"Diana", 
				"Petya", 
				"Stella", 
				"Elena", 
				"Katya", 
				"Iva", 
				"Annie", 
				"Eva" };
		String[] cities = new String[]{
				"Burgas", 
				"Sofiav", 
				"Plovdiv",
				"Varna", 
				"Ruse" };
		
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			System.out.printf("%s %s %s - %s%n", 
					phrases[random.nextInt(phrases.length)],
					events[random.nextInt(events.length)],
					authors[random.nextInt(authors.length)],
					cities[random.nextInt(cities.length)]);
		}
		
	}

}
