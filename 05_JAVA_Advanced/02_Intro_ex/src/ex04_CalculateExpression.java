import java.util.Scanner;

public class ex04_CalculateExpression {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Double numA = scanner.nextDouble();
		Double numB = scanner.nextDouble();
		Double numC = scanner.nextDouble();
		
		scanner.close();
		
		Double resultOne = Math.pow((
				Math.pow(numA, 2) + Math.pow(numB, 2)) 
				/ (Math.pow(numA, 2) - Math.pow(numB, 2))
				, ((numA + numB + numC) / Math.sqrt(numC)));
		
		Double resultTwo = Math.pow(
				Math.pow(numA, 2) + Math.pow(numB, 2) - Math.pow(numC, 3)
				, (numA - numB));
		
		Double finalResult =  Math.abs(((numA + numB + numC) / 3) - ((resultOne + resultTwo) / 2));
		
		System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", 
				resultOne, 
				resultTwo, 
				finalResult);
		
	}

}
