import java.util.Scanner;

public class lab03_AverageOfThree {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Double sum = 0.0;
		for (int i = 0; i < 3; i++) {
			sum += scanner.nextDouble();
		}
		scanner.close();
		
		System.out.printf("%.2f%n", sum / 3);

	}

}
