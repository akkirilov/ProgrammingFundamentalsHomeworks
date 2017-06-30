import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).toArray();
		scanner.close();
		
		int pos = 0;
		int len;
		int count = 1;
		
		for (int i = 0; i < arr.length - 1; i++) {;
			len = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					len++;
				} else {
					break;
				}
			}
			if (len > count) {
				pos = i;
				count = len;
				i += len - 1;
			}
		}
		
		printSubstractIntArray(arr, pos, count);

	}
	
	private static void printSubstractIntArray(int[] arr, int start, int count) {	
		for (int i = start; i < start + count; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
