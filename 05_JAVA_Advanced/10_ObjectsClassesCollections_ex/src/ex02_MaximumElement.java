import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ex02_MaximumElement {

	public static void main(String[] args) throws IOException {

		Deque<Integer> seq = new ArrayDeque<>();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Integer n = Integer.parseInt(bfr.readLine());
		for (int i = 0; i < n; i++) {

			int[] tokens = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			switch (tokens[0]) {
				case 1:
					seq.push(tokens[1]);
					break;
				case 2:
					seq.pop();
					break;
				case 3:
					System.out.println(getMaxElement(seq));
					break;
				default:
					break;
			}

		}

		bfr.close();

	}

	private static Integer getMaxElement(Deque<Integer> seq) {
		return new ArrayList<>(seq)
				.stream()
				.max((a, b) -> a.compareTo(b))
				.orElse(null);
	}

}
