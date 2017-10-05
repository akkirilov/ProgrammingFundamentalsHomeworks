import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ex01_ReverseArray {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bfr.readLine().split("\\s+");
		bfr.close();
		
		int startIndex = 0;
		int endIndex = arr.length - 1;
		
		swapElements(arr, startIndex, endIndex);
		
		System.out.println(Arrays.toString(arr).replaceAll("\\[|\\]|,", ""));
		
	}

	private static void swapElements(String[] arr, int startIndex, int endIndex) {
		
		if (startIndex >= endIndex) {
			return;
		}
		
		String temp = arr[startIndex];
		arr[startIndex] = arr[endIndex];
		arr[endIndex] = temp;
		
		swapElements(arr, startIndex + 1, endIndex - 1);
		
	}

}
