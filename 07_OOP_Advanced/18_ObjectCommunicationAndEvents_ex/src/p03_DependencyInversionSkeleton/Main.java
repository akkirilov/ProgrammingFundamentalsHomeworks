package p03_DependencyInversionSkeleton;

import java.util.Scanner;

import p03_DependencyInversionSkeleton.contracts.*;
import p03_DependencyInversionSkeleton.models.*;
import p03_DependencyInversionSkeleton.strategies.*;

public class Main {

	private static Strategy ADDITION_STRATEGY = new AdditionStrategy();
	private static Strategy SUBTRACTION_STRATEGY = new SubtractionStrategy();
	private static Strategy DIVISION_STRATEGY = new DivisionStrategy();
	private static Strategy MULTIPLICATION_STRATEGY = new MultiplicationStrategy();
	

	public static void main(String[] args) {
		
		PrimitiveCalculator calculator = new PrimitiveCalculator();
		calculator.changeStrategy(ADDITION_STRATEGY);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String[] tokens = scanner.nextLine().split("\\s+");
			if (tokens[0].equalsIgnoreCase("end")) {
				break;
			} else if (tokens[0].equalsIgnoreCase("mode")) {
				calculator.changeStrategy(getStrategy(tokens[1]));
			} else {
				try {
					int res = calculator.performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
					System.out.println(res);
				} catch (Exception e) {
					System.out.println("ERROR: Invalid number format!!!");
				}
			}
			
		}
		
		scanner.close();

	}


	private static Strategy getStrategy(String str) {
		switch (str) {
		case "*":
			return MULTIPLICATION_STRATEGY;
		case "/":
			return DIVISION_STRATEGY;
		case "-":
			return SUBTRACTION_STRATEGY;
		default:
			return ADDITION_STRATEGY;
		}
	}

}
