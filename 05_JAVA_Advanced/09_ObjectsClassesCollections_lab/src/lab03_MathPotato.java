import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class lab03_MathPotato {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> children = new ArrayDeque<>(Arrays.asList(bfr.readLine().split("\\s+")));
		Integer n = Integer.parseInt(bfr.readLine());
		bfr.close();

		Integer countLoops = 1;
		while (children.size() > 1) {
			for (int j = 1; j < n; j++) {
				children.offer(children.poll());
			}
			if (isPrime(countLoops)) {
				System.out.println("Prime " + children.peek());
			} else {
				System.out.println("Removed " + children.poll());
			}

			countLoops++;
		}

		System.out.println("Last is " + children.poll());

	}

	private static boolean isPrime(int j) {
		
		if (j == 1) {
			return false;
		}
		for (int i = 2; i < j; i++) {
			if (j % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}

}
