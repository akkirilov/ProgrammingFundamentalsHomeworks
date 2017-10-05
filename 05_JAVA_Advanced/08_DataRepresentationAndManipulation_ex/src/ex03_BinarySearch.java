import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex03_BinarySearch {

	private static int[] arr;
	private static int x;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		arr = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		x = Integer.parseInt(bfr.readLine());
		bfr.close();

		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		
		if (arr[start] == x) {
			System.out.println(start);
			return;
		} else if (arr[end] == x){
			System.out.println(end);
			return;
		}
		
		search(start, end, mid);
		
	}

	private static void search(int start, int end, int mid) {
		
		if (start >= end || arr[end] < x) {
			System.out.println(-1);
			return;
		}
		
		if (arr[mid] > x) {
			search(start, mid, (start + mid) / 2);
		} else if (arr[mid] < x) {
			search(mid, end, (mid + end) / 2);
		} else {
			System.out.println(mid);
			return;
		}
		
	}

}
