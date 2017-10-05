import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lab02_Searching {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		int x = Integer.parseInt(bfr.readLine());
		
		bfr.close();
		
		//linearSearchAndPrint(arr, x);
		
		binarySearchAndPrint(arr, x);
		
	}

	private static void binarySearchAndPrint(int[] arr, int x) {
		
		int index = -1;
		int start = 0;
		int end = arr.length - 1;
		int mid = end / 2;
				
		if (arr[end] < x) {
			System.out.println(-1);
			return;
		} else if (arr[end] == x) {
			System.out.println(end);
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[mid] > x) {
				end = mid;
				mid = (start + end) / 2;
			} else if (arr[mid] < x) {
				start = mid;
				mid = (start + end) / 2;
			} else {
				index = mid;
				break;
			}
		}
		
		System.out.println(index);
		
	}

	private static void linearSearchAndPrint(int[] arr, int x) {

		int index = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				index = i;
				break;
			}
		}
		
		System.out.println(index);
		
	}

}
