import java.util.Scanner;

public class ex03_DiagonalDifference {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Integer size = scanner.nextInt();
		
		Integer sumToDown = 0;
		Integer sumToUp = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Integer temp = scanner.nextInt();
				if (i == j) {
					sumToDown += temp;
				}
				if (size - 1 - i == j) {
					sumToUp += temp;
				}
			}
		}

		scanner.close();
	
		Integer diff = Math.abs(sumToUp - sumToDown);
		System.out.println(diff);
		
	}

}
