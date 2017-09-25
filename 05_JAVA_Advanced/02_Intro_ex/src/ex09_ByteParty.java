import java.util.Scanner;

public class ex09_ByteParty {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Integer n = scanner.nextInt();
		Integer[] numbers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		scanner.nextLine();
		
		String[] command = scanner.nextLine().split("\\s+");
		while (!command[0].equals("party") && !command[1].equals("over")) {
			Integer position = Integer.parseInt(command[1]);
			switch (command[0]) {
			case "-1":
				flipBits(numbers, position);
				break;
			case "0":
				unsetBits(numbers, position);
				break;
			case "1":
				setBits(numbers, position);
			default:
				break;
			}
			
			command = scanner.nextLine().split("\\s+");
			
		}
		
		scanner.close();
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

	}

	private static void setBits(Integer[] array, Integer position) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] | (1 << position);
		}
		
	}

	private static void unsetBits(Integer[] array, Integer position) {
		
		for (int i = 0; i < array.length; i++) {
				array[i] = array[i] & ~(1 << position);
		}
		
	}

	private static void flipBits(Integer[] array, Integer position) {
		
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] ^ (1 << position);
		}
		
	}

}
