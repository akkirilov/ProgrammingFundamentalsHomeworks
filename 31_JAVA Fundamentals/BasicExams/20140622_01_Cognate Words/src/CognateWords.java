import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CognateWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] symbols = scanner.nextLine().toCharArray();
		
		List<String> words = new ArrayList<>(); 
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < symbols.length; i++) {
			if (Character.isLetter(symbols[i]) && symbols[i] < 150) {
				sb.append(symbols[i]);
			}
			else {
				if (!sb.toString().equals("")) {
					words.add(sb.toString());					
				}
				
				sb.setLength(0);
			}
		}
		
		words.add(sb.toString());
		
		Set<String> mathes = new HashSet<>();
		
		String wordA;
		String wordB;
		String wordC;
		for (int i = 0; i < words.size(); i++) {
			wordC = words.get(i);
			for (int j = 0; j < words.size(); j++) {
				wordA = words.get(j);
				for (int k = 0; k < words.size(); k++) {
					wordB = words.get(k);
					if (j != k && wordC.equals(wordA + wordB) && !wordA.equals("") && !wordB.equals("")) {
						mathes.add(wordA + "|" + wordB + "=" + wordC);
						break;
					}
				}
			}
		}
		
		if (mathes.size() <= 0) {
			System.out.printf("%s", "No");
		}
		else {
			for (String entry : mathes) {
				System.out.println(entry);
			}
		}
	}
}