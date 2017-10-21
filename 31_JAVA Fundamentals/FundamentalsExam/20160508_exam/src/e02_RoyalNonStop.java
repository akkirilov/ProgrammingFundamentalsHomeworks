import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class e02_RoyalNonStop {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = reader.readLine().split("\\s+");
		Integer row = Integer.parseInt(tokens[0]);
		Integer col = Integer.parseInt(tokens[1]);
		
		double[] prices = new double[2];
		tokens = reader.readLine().split("\\s+");
		prices[0] = Double.parseDouble(tokens[0]);
		prices[1] = Double.parseDouble(tokens[1]);
		
		BigDecimal sum = BigDecimal.ZERO;
		Integer counter = 0;
		tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("Royal")) {
			
			row = Integer.parseInt(tokens[0]);
			col = Integer.parseInt(tokens[1]);
			
			BigDecimal rowValue;
			BigDecimal colValue;
			
			BigDecimal costumerSum = BigDecimal.ZERO;
			
			if (row < col) {
				for (; row > 0; row--) {
					rowValue = new BigDecimal(row + 1);
					colValue = new BigDecimal(col + 1);
					BigDecimal currPrice = new BigDecimal(prices[row % 2]);
					costumerSum = costumerSum.add(rowValue.multiply(colValue).multiply(currPrice));
				}
				for (; col > 0; col--) {
					colValue = new BigDecimal(col + 1);
					BigDecimal currPrice = new BigDecimal(prices[row % 2]);
					costumerSum = costumerSum.add(colValue.multiply(currPrice));
				}
			} else {
				for (; col > 0; col--) {
					colValue = new BigDecimal(col + 1);
					rowValue = new BigDecimal(row + 1);
					BigDecimal currPrice = new BigDecimal(prices[row % 2]);
					costumerSum = costumerSum.add(rowValue.multiply(colValue).multiply(currPrice));
				}
				for (; row > 0; row--) {
					rowValue = new BigDecimal(row + 1);
					BigDecimal currPrice = new BigDecimal(prices[row % 2]);
					costumerSum = costumerSum.add(rowValue.multiply(currPrice));
				}
			}
			
			sum = sum.add(costumerSum);
			counter++;
			
			tokens = reader.readLine().split("\\s+");
			
		}
		
		System.out.println(sum.setScale(6, RoundingMode.HALF_EVEN));
		System.out.println(counter);
		
		reader.close();

	}

}
