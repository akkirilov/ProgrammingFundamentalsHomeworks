import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ex09_TheStockSpanProblem {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfDays = Integer.parseInt(reader.readLine());

		int[] span = new int[numberOfDays];
		double[] prices = new double[numberOfDays];
		for (int i = 0; i < numberOfDays; i++) {
			prices[i] = Double.parseDouble(reader.readLine());
		}
		reader.close();

		calculateSpan(prices, numberOfDays, span);

		StringBuilder result = new StringBuilder();
		for (int i : span) {
			result.append(i).append("\r\n");
		}

		System.out.println(result.toString());
	}

	static void calculateSpan(double[] prices, int n, int[] span) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		span[0] = 1;

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
			stack.push(i);
		}
	}
}
