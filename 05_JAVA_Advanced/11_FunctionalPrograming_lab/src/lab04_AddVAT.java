import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class lab04_AddVAT {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] prices = bfr.readLine().split("\\s*,\\s*");
		
		Function<String, Double> parseToDouble = x -> Double.parseDouble(x);
		UnaryOperator<Double> addVAT = x -> x *= 1.2;
		
		System.out.printf("Prices with VAT:%n");
		for (int i = 0; i < prices.length; i++) {
			System.out.println(String.format("%1$.2f", addVAT.apply(parseToDouble.apply(prices[i]))).replaceAll("\\.", ","));
		}
		
		bfr.close();
		
	}

}
