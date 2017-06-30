import java.util.Scanner;

class BooleanVariable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean input = Boolean.parseBoolean(scanner.nextLine());
		scanner.close();
		
		if (input) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
