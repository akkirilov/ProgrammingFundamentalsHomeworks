import java.util.Scanner;

public class lab02_ReadInput {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String wordOne = scanner.next();
		String wordTwo = scanner.next();
		Integer numOne = scanner.nextInt();
		Integer numTwo = scanner.nextInt();
		Integer numThree = scanner.nextInt();
		
		scanner.nextLine();
		String wordLast = scanner.nextLine();
		
		scanner.close();
		
		System.out.printf("%s %s %s %d %n", wordOne, wordTwo, wordLast, (numOne + numTwo + numThree));

	}

}
