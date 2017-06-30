import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).toArray();
		scanner.close();
		
		int start = 0;
		int end = 0;
		int count = 1;
		
		for (int i = 0; i < arr.length - 1; i++) {	
			if (arr[i] < arr[i + 1]) {
				count++;
				if (count > end - start) {
					end = i + 2;
					start = end - count;
				}
			} else {
				count = 1;
			}
		}
		
		printSubstractIntArray(arr, start, end);
		
	}
	
	private static void printSubstractIntArray(int[] arr, int start, int end) {	
		for (int i = start; i < end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
