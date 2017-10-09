import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ex01_BasicStackOperations {

	public static void main(String[] args) throws IOException {

		Deque<Integer> numbers = new ArrayDeque<>();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bfr.readLine().split("\\s+");

		Integer toPush = Integer.parseInt(input[0]);
		Integer toPop = Integer.parseInt(input[1]);
		Integer toFind = Integer.parseInt(input[2]);

		input = bfr.readLine().split("\\s+");
		for (int j = 0; j < toPush; j++) {
			numbers.push(Integer.parseInt(input[j]));
		}

		bfr.close();

		for (int i = 0; i < toPop; i++) {
			if (numbers.size() >= 1) {
				numbers.pop();
			}
		}

		if (numbers.contains(toFind)) {
			System.out.println("true");
		} else if (numbers.size() < 1) {
			System.out.println(0);
		} else {
			List<Integer> sNumbers = new ArrayList<>(numbers);
			Collections.sort(sNumbers);
			System.out.println(sNumbers.get(0));
		}

	}

}
