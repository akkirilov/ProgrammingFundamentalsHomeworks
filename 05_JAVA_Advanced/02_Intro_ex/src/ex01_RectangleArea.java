import java.util.Scanner;

public class ex01_RectangleArea {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Double sideA = scanner.nextDouble();
		Double sideB = scanner.nextDouble();
		
		scanner.close();
		
		Double area = sideA * sideB;
		
		System.out.printf("%n%.2f%n", area);
		
	}

}
