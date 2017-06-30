import java.util.Scanner;

public class CompareCharArrays {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		char[] arr1 = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		char[] arr2 = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		scanner.close();

		int minLength = Math.min(arr1.length, arr2.length);
		for (int i = 0; i < minLength; i++) {
			if (arr1[i] < arr2[i]) {
				printCharArray(arr1);
				printCharArray(arr2);
				return;
			} else if (arr1[i] > arr2[i]) {
				printCharArray(arr2);
				printCharArray(arr1);
				return;
			}
		}
		
		if (arr1.length <= arr2.length) {
			printCharArray(arr1);
			printCharArray(arr2);
		} else if (arr1.length > arr2.length) {
			printCharArray(arr2);
			printCharArray(arr1);
		}
				
	}
	
	private static void printCharArray(char[] charArray) {	
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		System.out.println();
	}
	
}
