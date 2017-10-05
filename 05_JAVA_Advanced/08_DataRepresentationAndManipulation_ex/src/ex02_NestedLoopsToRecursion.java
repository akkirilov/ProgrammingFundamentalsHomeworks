import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex02_NestedLoopsToRecursion {

	private static int n;
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bfr.readLine());
		bfr.close();
		
		arr = new int[n];

		fillNext(0);

	}

	private static void fillNext(int currIndex) {
		
		if (currIndex >= n) {
			System.out.println(Arrays.toString(arr).replaceAll("\\[|\\]|,", ""));
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[currIndex] = i;
			fillNext(currIndex + 1);
		}

	}

}
