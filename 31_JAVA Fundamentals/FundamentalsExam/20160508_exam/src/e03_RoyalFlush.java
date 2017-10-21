import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class e03_RoyalFlush {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		StringBuilder input = new StringBuilder();
		for (int i = 0; i < n; i++) {
			input.append(reader.readLine());
		}
		
		reader.close();
		
		String allCards = input.toString().replaceAll("0", "");
		TreeSet<Integer> tenIndexes = new TreeSet<>();
		for (int i = 0; i < allCards.length(); i += 2) {
			if (getValue(allCards.charAt(i)) == 10) {
				tenIndexes.add(i);
			}
		}
		
		String suit;
		Integer value;
		Integer lastValue = 0;
		String lastSuit = "";
		Integer counter = 0;
		List<String> hand = new ArrayList<>();
		for (Integer currIndex : tenIndexes) {
			
			lastValue = getValue(allCards.charAt(currIndex));
			lastSuit = getSuit(allCards.charAt(currIndex + 1));
			hand = new ArrayList<>();
			hand.add(lastValue + lastSuit);
			
			for (int i = currIndex + 2; i < allCards.length(); i += 2) {
				value = getValue(allCards.charAt(i));
				suit = getSuit(allCards.charAt(i + 1));
				if (value - lastValue != 1 && suit.equals(lastSuit)) {
					break;
				} else if (value - lastValue == 1 && suit.equals(lastSuit)) {
					hand.add(value + suit);
					lastValue = value;
				}
			}
			
			if (hand.size() == 5) {
				System.out.println("Royal Flush Found - " + lastSuit);
				counter++;
				hand = new ArrayList<>();
			}
			
		}
		
		System.out.printf("Royal's Royal Flushes - %d.%n", counter);

	}

	private static String getSuit(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 's':
			return "Spades";
		case 'd':
			return "Diamonds";
		case 'h':
			return "Hearts";
		case 'c':
			return "Clubs";
		}
		return null;
	}

	private static Integer getValue(char ch) {
		switch (ch) {
		case '1':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;
		default:
			return 0;
		}
	}

}
