import java.util.Scanner;

public class lab01_CalculateTriangleArea {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Double base = scanner.nextDouble();
		Double heigth = scanner.nextDouble();
		
		scanner.close();
		
		Double area = calculateTriangleArea(base, heigth);
		
		System.out.printf("Area = %.2f%n", area);
		
	}

	private static Double calculateTriangleArea(Double base, Double heigth) {
		return (base * heigth) / 2;
	}

}
