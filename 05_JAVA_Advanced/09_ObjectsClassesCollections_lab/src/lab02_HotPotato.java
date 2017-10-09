import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class lab02_HotPotato {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> children = new ArrayDeque<>(Arrays.asList(bfr.readLine().split("\\s+")));
		Integer n = Integer.parseInt(bfr.readLine());
		bfr.close();

		while (children.size() > 1) {
			for (int j = 1; j <= n; j++) {
				if (j == n) {
					System.out.println("Removed " + children.poll());
				} else {
					children.add(children.poll());
				}
				
			}

		}
		
		System.out.println("Last is " + children.poll());

	}

}
