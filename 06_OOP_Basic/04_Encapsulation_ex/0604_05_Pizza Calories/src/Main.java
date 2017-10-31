import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String[] tokens = reader.readLine().split("\\s+");
			
			Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));

			tokens = reader.readLine().split("\\s+");
			pizza.setDough(new Dough(tokens[1], tokens[2], Integer.parseInt(tokens[3])));

			tokens = reader.readLine().split("\\s+");
			while (!tokens[0].equals("END")) {
				pizza.addTopping(new Topping(tokens[1], Integer.parseInt(tokens[2])));
				tokens = reader.readLine().split("\\s+");
			}
			
			System.out.println(pizza);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}

	}

}
