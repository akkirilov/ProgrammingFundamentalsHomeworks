import java.util.Scanner;

public class lab10_ExtractBit {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer number = scanner.nextInt();
		Integer position = scanner.nextInt();
		
		scanner.close();
		
		if (((number >> position) & 1) == 1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
