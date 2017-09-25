import java.math.BigInteger;
import java.util.Scanner;

public class lab08_ProductOfNumbers {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer numOne = scanner.nextInt();
		Integer numTwo = scanner.nextInt();
		scanner.close();
		
		BigInteger product = BigInteger.valueOf(1);
		for (int i = numOne; i <= numTwo; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}

		System.out.printf("product[%d..%d] = %d%n", numOne, numTwo, product);
		
	}

}
