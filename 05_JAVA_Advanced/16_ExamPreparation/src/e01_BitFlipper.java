import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class e01_BitFlipper {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BigInteger number = new BigInteger(reader.readLine());
		reader.close();

		for (int i = 63; i > 1; i--) {
			if (number.testBit(i)
					&& number.testBit(i - 1)
					&& number.testBit(i - 2)) {
				number = flipToZero(number, i);
				i -= 2;
			} else if (!number.testBit(i)
					&& !number.testBit(i - 1)
					&& !number.testBit(i - 2)) {
				number = flipToOne(number, i);
				i -= 2;
			}
		}
		
		System.out.println(number);
		
	}

	private static BigInteger flipToOne(BigInteger number, int i) {
		number = number.setBit(i);
		number = number.setBit(i - 1);
		number = number.setBit(i - 2);
		return number;
	}

	private static BigInteger flipToZero(BigInteger number, int i) {
		number = number.flipBit(i);
		number = number.flipBit(i - 1);
		number = number.flipBit(i - 2);
		return number;
	}

}
