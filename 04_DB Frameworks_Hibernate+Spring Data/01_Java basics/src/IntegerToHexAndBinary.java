import java.util.Scanner;

class IntegerToHexAndBinary {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.nextLine());
		scanner.close();

		System.out.println(Integer.toHexString(input).toUpperCase());
		System.out.println(Integer.toBinaryString(input));
		
	}

}
