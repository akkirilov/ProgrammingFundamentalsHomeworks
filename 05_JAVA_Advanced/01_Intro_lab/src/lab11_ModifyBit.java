import java.util.Scanner;

public class lab11_ModifyBit {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer number = scanner.nextInt();
		Integer position = scanner.nextInt();
		Integer value = scanner.nextInt();
		
		scanner.close();

		if (value == 0) {
			number = number & ~(1 << position);
		} else {
			number = number | (1 << position);
		}

		System.out.println(number);

	}

}
