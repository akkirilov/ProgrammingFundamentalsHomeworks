import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class lab02_EncryptSortndPrintArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer n = Integer.parseInt(scanner.nextLine());
		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		List<Character> vowels = new ArrayList<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('o');
		vowels.add('i');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('O');
		vowels.add('I');
		vowels.add('U');
		
		Integer[] pointList = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			
			Integer points = 0;
			String word = names[i];
			Integer length = word.length();
			for (int j = 0; j < length; j++) {
				
				if (vowels.contains(word.charAt(j))) {
					points += (word.charAt(j) * length);
				} else {
					points += (word.charAt(j) / length);
				}
				
			}
			
			pointList[i] = points;
			
		}
		
		Arrays.sort(pointList);
		
		for (Integer p : pointList) {
			System.out.println(p);
		}
		
	}

}
