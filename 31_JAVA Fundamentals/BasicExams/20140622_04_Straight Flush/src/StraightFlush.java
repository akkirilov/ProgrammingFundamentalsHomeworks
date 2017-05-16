import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class StraightFlush {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split(",\\s+|\\s+");
		
		Map<Character, TreeSet<Integer>> cards = new HashMap<>();
		cards.put('S', new TreeSet<>());
		cards.put('H', new TreeSet<>());
		cards.put('D', new TreeSet<>());
		cards.put('C', new TreeSet<>());
		
		char currentChar = ' ';
		int value = 0;
		for (int i = 0; i < tokens.length; i++) {
			currentChar = tokens[i].charAt(tokens[i].length() - 1);
			value = getCardIntValue(tokens[i].substring(0, tokens[i].length() - 1));
			
			cards.get(currentChar).add(value);
		}
		
		boolean found = false;
		
		for (Map.Entry <Character, TreeSet<Integer>> entry : cards.entrySet()) {
			if(entry.getValue().size() >= 1) {
				
				List<Integer> cardValue = new ArrayList<Integer> (entry.getValue());
				List<String> flushes = new ArrayList<>();
				
				for (int i = 0; i < cardValue.size(); i++) {
					
					flushes.clear();
					flushes.add("" + getCardStringValue(cardValue.get(i)) + entry.getKey());
					
					for (int j = i + 1; j < cardValue.size(); j++) {
						
						if (cardValue.get(j - 1) + 1 == cardValue.get(j)) {
							
							flushes.add("" + getCardStringValue(cardValue.get(j)) + entry.getKey());
							
							if (flushes.size() == 5) {
								System.out.println(flushes);
								
								flushes.clear();
								found = true;
								
								break;
							}
						}
						else {
							break;
						}					
					}
				}
			}
		}
		
		if (!found) {
			System.out.println("No Straight Flushes");
		}
	}

	private static String getCardStringValue(Integer cardValue) {
		String stringValue = "";
		if (cardValue == 11) {
			stringValue = "J";
		}
		else if (cardValue == 12) {
			stringValue = "Q";
		}
		else if (cardValue == 13) {
			stringValue = "K";
		}
		else if (cardValue == 14) {
			stringValue = "A";
		}
		else {
			stringValue = cardValue.toString();
		}
		
		return stringValue;
	}

	private static int getCardIntValue(String substring) {
		int value = 0;
		if (substring.equals("J")) {
			value = 11;
		}
		else if (substring.equals("Q")) {
			value = 12;
		}
		else if (substring.equals("K")) {
			value = 13;
		}
		else if (substring.equals("A")) {
			value = 14;
		}
		else {
			value = Integer.parseInt(substring);
		}
		
		return value;
	}
}