import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Person> persons = new ArrayList<>();
	private static List<Product> products = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens;
		String[] input = reader.readLine().split(";");
		for (int i = 0; i < input.length; i++) {
			tokens = input[i].split("=");
			try {
				persons.add(new Person(tokens[0], Double.parseDouble(tokens[1])));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		
		input = reader.readLine().split(";");
		for (int i = 0; i < input.length; i++) {
			tokens = input[i].split("=");
			try {
				products.add(new Product(tokens[0], Double.parseDouble(tokens[1])));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		
		tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("END")) {
			
			System.out.println(tryToBuyProduct(tokens));
			
			tokens = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		printPersons();

	}

	private static void printPersons() {
		for (Person p : persons) {
			System.out.println(p);
		}
	}

	private static String tryToBuyProduct(String[] tokens) {
		String res = "Invalid input!";
		Product tempProduct = null;
		for (Product p : products) {
			if (p.getName().equals(tokens[1])) {
				tempProduct = p;
			}
			
		}
		
		for (Person p : persons) {
			if (p.getName().equals(tokens[0])) {
				res = p.buyProduct(tempProduct);
				break;
			}
		}
		return res;
	}

}
