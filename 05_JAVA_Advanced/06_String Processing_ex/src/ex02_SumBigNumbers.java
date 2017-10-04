import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex02_SumBigNumbers {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String numOne = bfr.readLine();
		String numTwo = bfr.readLine();
		
		bfr.close();

		String sum = sumBigNumbers(numOne, numTwo);
		printDigit(sum);
		
	}

	private static void printDigit(String sum) {
		
		boolean printedDigit = false;
		for (int i = 0; i <sum.length(); i++) {
			if (!printedDigit && sum.charAt(i) != '0') {
				printedDigit = true;
			}
			if (printedDigit) {
				System.out.print(sum.charAt(i));
			}
		}
				
		System.out.println();
		
	}

	private static String sumBigNumbers(String numOneStr, String numTwoStr) {
		
		Integer length = Math.max(numOneStr.length(), numTwoStr.length()) - 1;
		int[] numOne = new int[length + 1];		
		for (int i = numOneStr.length() - 1; i >= 0; i--) {
			numOne[length] = Integer.parseInt(numOneStr.charAt(i) + "");
			length--;
		}
		
		length = Math.max(numOneStr.length(), numTwoStr.length()) - 1;
		int[] numTwo = new int[length + 1];
		for (int i = numTwoStr.length() - 1; i >= 0; i--) {
			numTwo[length] = Integer.parseInt(numTwoStr.charAt(i) + "");
			length--;
		}
		
		length = Math.max(numOneStr.length(), numTwoStr.length()) - 1;
		StringBuffer result = new StringBuffer();
		Integer sum = 0;
		Integer reminder = 0;
				
		for (int i = length; i >= 0; i--) {
			sum = numOne[i] + numTwo[i] + reminder;
			if (sum > 9) {
				result.insert(0, sum.toString().charAt(sum.toString().length() - 1));
				reminder = Integer.parseInt(sum.toString().substring(0, sum.toString().length() - 1));
			} else {
				result.insert(0, sum.toString());
				reminder = 0;
			}
		}
		
		if (reminder > 0) {
			result.insert(0, reminder);
		}
		
		return result.toString();
	}

}
