import java.util.Scanner;

public class ex04_2x2SquaresInMatrix {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s+");

		Integer rows = Integer.parseInt(input[0]);
		Integer cols = Integer.parseInt(input[1]);
		String[][] matrix = new String[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.next();
			}
		}
		
		scanner.close();

		Integer counter = find2x2(matrix);
		System.out.println(counter);
		
	}

	private static Integer find2x2(String[][] matrix) {
		
		Integer counter = 0;
		for (int i = 0; i < matrix.length - 1; i++) {
			
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j].equals(matrix[i][j + 1])) {
					if (matrix[i][j].equals(matrix[i + 1][j]) 
							&& matrix[i][j].equals(matrix[i + 1][j + 1])) {
						counter++;
					}
				}
			}
			
		}
		
		return counter;
		
	}

}
