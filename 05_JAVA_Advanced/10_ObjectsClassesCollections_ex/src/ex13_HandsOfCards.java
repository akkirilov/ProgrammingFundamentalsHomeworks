import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ex13_HandsOfCards {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Set<String>> playersData = new LinkedHashMap<>();
		String[] input = bfr.readLine().split(":");
		while (!input[0].equals("JOKER")) {
			
			String[] inputCards = input[1].split(",");
			Set<String> cards = new HashSet<>();
			for (int i = 0; i < inputCards.length; i++) {
				cards.add(inputCards[i].trim());
			}

			if (!playersData.containsKey(input[0])) {
				playersData.put(input[0], cards);
			} else {
				cards.addAll(playersData.get(input[0]));
				playersData.put(input[0], cards);
			}

			input = bfr.readLine().split(":");

		}

		bfr.close();

		for (Map.Entry<String, Set<String>> pair : playersData.entrySet()) {
			System.out.printf("%s: %d%n", pair.getKey(), calculatePoints(pair.getValue()));
		}

	}

	private static Integer calculatePoints(Set<String> cards) {

		Integer sum = 0;

		for (String card : cards) {
			switch (card.trim().charAt(0)) {
			case '1':
				sum += 10 * getMultiplier(card);
				break;
			case '2':
				sum += 2 * getMultiplier(card);
				break;
			case '3':
				sum += 3 * getMultiplier(card);
				break;
			case '4':
				sum += 4 * getMultiplier(card);
				break;
			case '5':
				sum += 5 * getMultiplier(card);
				break;
			case '6':
				sum += 6 * getMultiplier(card);
				break;
			case '7':
				sum += 7 * getMultiplier(card);
				break;
			case '8':
				sum += 8 * getMultiplier(card);
				break;
			case '9':
				sum += 9 * getMultiplier(card);
				break;
			case 'J':
				sum += 11 * getMultiplier(card);
				break;
			case 'Q':
				sum += 12 * getMultiplier(card);
				break;
			case 'K':
				sum += 13 * getMultiplier(card);
				break;
			case 'A':
				sum += 14 * getMultiplier(card);
				break;
			default:
				break;
			}
		}

		return sum;
	}

	private static Integer getMultiplier(String card) {

		switch (card.charAt(card.length() - 1)) {
		case 'S':
			return 4;
		case 'H':
			return 3;
		case 'D':
			return 2;
		case 'C':
			return 1;
		default:
			return 1;
		}

	}

}
