import java.util.Scanner;

class VariableHexadecimal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println(Integer.parseInt(input, 16));
		
	}

}
