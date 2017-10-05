import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lab03_RecursiveArraySum {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
				
		bfr.close();
		
		Integer index = arr.length - 1;
		Integer sum = recursiveArraySum(arr, index);
		
		System.out.println(sum);
		
	}

	private static Integer recursiveArraySum(int[] arr, Integer index) {
		
		if (index <= 0) {
			return arr[index];
		}
		
		return arr[index] + recursiveArraySum(arr, index - 1);
	}

}
