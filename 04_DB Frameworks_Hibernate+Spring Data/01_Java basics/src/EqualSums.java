import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).toArray();
		scanner.close();
		
		if (arr.length == 1) {
			System.out.println(0);
			return;
		}
		
		int left;
		int right;
		
		for (int i = 0; i < arr.length; i++) {
			left = 0;
			for (int j = 0; j < i; j++) {
				left += arr[j];
			}
			
			right = 0;
			for (int j = i + 1; j < arr.length; j++) {
				right += arr[j];
				if (right > left) {
					break;
				}
			}
			
			if (left == right) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("no");
		
	}

}
