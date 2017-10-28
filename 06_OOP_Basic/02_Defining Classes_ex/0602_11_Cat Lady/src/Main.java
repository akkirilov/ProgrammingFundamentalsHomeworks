import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Cat> CATS = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Cat tempCat = null;
		String[] tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("End")) {

			switch (tokens[0]) {
			case "StreetExtraordinaire":
				tempCat = new StreetExtraordinaire(tokens[1], Double.parseDouble(tokens[2]));
				break;
			case "Siamese":
				tempCat = new Siamese(tokens[1], Double.parseDouble(tokens[2]));
				break;
			case "Cymric":
				tempCat = new Cymric(tokens[1], Double.parseDouble(tokens[2]));
				break;
			default:
				break;
			}
			
			CATS.add(tempCat);
			
			tokens = reader.readLine().split("\\s+");
		}
		
		printCat(reader.readLine());

		reader.close();

	}

	private static void printCat(String name) {
		for (Cat c : CATS) {
			if (c.getName().equals(name)) {
				if (c.getClass().getSimpleName().equals("StreetExtraordinaire")) {
					System.out.printf("%s %s %.2f%n", c.getClass().getSimpleName(), c.getName(), ((StreetExtraordinaire) c).getDecibelsOfMeows());
				} else if (c.getClass().getSimpleName().equals("Siamese")){
					System.out.printf("%s %s %.2f%n", c.getClass().getSimpleName(), c.getName(), ((Siamese) c).getEarSize());
				} else {
					System.out.printf("%s %s %.2f%n", c.getClass().getSimpleName(), c.getName(), ((Cymric) c).getFurLength());
				}
			}
		}
	}

}
