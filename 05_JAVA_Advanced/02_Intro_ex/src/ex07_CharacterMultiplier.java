import java.util.Scanner;

public class ex07_CharacterMultiplier {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String textA = scanner.next();
		String textB = scanner.next();
		
		scanner.close();
		
		Integer sum = 0;
		Integer counter = 0;
		Integer length = Math.min(textA.length(), textB.length());
		
		for (;counter < length; counter++) {
			sum += (textA.charAt(counter) * textB.charAt(counter));
		}
		
		if (textA.length() < textB.length()) {
			length = textB.length();
			for (;counter < length; counter++) {
				sum += textB.charAt(counter);
			}
		} else if (textA.length() > textB.length()) {
			length = textA.length();
			for (;counter < length; counter++) {
				sum += textA.charAt(counter);
			}
		}
		
		System.out.println(sum);
		
	}

}
