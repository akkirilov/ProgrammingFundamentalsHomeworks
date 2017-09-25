import java.util.Scanner;

public class ex03_FormattingNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer numA = scanner.nextInt();
		
		Double numB = scanner.nextDouble();
		
		Double numC = scanner.nextDouble();
		
		scanner.close();
		
		System.out.printf("|%-10s|", Integer.toHexString(numA).toUpperCase());
		System.out.printf("%s|", String.format("%10s", Integer.toBinaryString(numA)).replace(" ", "0"));
		System.out.printf("%10s|", String.format("%.2f", numB));
		System.out.printf("%-10s|", String.format("%.3f", numC));
		
	}

}
