import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e01_HandScore {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] cards = reader.readLine().split("\\s+");
		reader.close();
		
		Integer points = 0;
		Integer currPoints = 0;
		Integer counter = 0;
		char suit;
		char oldSuit = cards[0].charAt(cards[0].length() - 1);
		for (int i = 0; i <= cards.length; i++) {
			
			if (i == cards.length) {
				points += (currPoints * counter);
				System.out.println(points);
				return;
			}
			
			suit = cards[i].charAt(cards[i].length() - 1);
			if (suit != oldSuit) {
				oldSuit = suit;
				points += (currPoints * counter);
				counter = 0;
				currPoints = 0;
			}
			
			currPoints += getCurrValue(cards[i].substring(0, cards[i].length() - 1));
			counter++;
			
		}
		
	}

	private static Integer getCurrValue(String card) {
		switch (card.charAt(0)) {
		case '1':
			return 10;
		case 'J':
			return 12;
		case 'Q':
			return 13;	
		case 'K':
			return 14;	
		case 'A':
			return 15;	
		default:
			return Integer.parseInt(card);
		}
	}

}
