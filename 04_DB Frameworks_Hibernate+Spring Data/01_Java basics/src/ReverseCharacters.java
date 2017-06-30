import java.util.Scanner;

public class ReverseCharacters {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer input = new StringBuffer();
		input.append(scanner.nextLine());
		input.append(scanner.nextLine());
		input.append(scanner.nextLine());
		scanner.close();
		
		System.out.println(input.reverse());

	}

}
