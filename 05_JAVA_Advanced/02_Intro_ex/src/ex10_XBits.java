import java.util.Scanner;

public class ex10_XBits {
	
	private final static Integer LENGTH = 8;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer[] numbers = new Integer[LENGTH];
		for (int i = 0; i < LENGTH; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		Integer counter = 0;
		for (int i = 0; LENGTH - i > 2; i++) {
			Integer numA = numbers[i];
			Integer numB = numbers[i + 1];
			Integer numC = numbers[i + 2];
			
			for (int j = 31; j > 1; j--) {
				
				if (((numA >> j) & 1) == 1 && ((numA >> (j - 1)) & 1) == 0 && ((numA >> (j - 2)) & 1) == 1) {
					if (((numB >> j) & 1) == 0 && ((numB >> (j - 1)) & 1) == 1 && ((numB >> (j - 2)) & 1) == 0) {
						if (((numC >> j) & 1) == 1 && ((numC >> (j - 1)) & 1) == 0 && ((numC >> (j - 2)) & 1) == 1) {
							counter++;
						}
					}
				}
				
			}
			
		}
		
		System.out.println(counter);

	}

}
