import java.util.Scanner;

public class IndexOfLetters {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[] arr = scanner.nextLine().toCharArray();
		scanner.close();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s -> %d%n", arr[i], arr[i] - 'a');
		}
		
	}

}
