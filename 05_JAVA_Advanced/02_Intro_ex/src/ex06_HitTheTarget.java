import java.util.Scanner;

public class ex06_HitTheTarget {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer target = scanner.nextInt();
		
		scanner.close();
		
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i + j == target) {
					System.out.printf("%d + %d = %d%n", i, j, target );
				}
			}
		}
		
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				if (i - j == target) {
					System.out.printf("%d - %d = %d%n", i, j, target );
				}
			}
		}
		
	}

}
