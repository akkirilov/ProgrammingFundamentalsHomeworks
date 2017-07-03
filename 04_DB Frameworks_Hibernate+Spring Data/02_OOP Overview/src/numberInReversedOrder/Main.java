package numberInReversedOrder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DecimalNumber num = new DecimalNumber(scanner.nextLine());
		scanner.close();
		
		System.out.println(num.reverseOrder());
	}

}
