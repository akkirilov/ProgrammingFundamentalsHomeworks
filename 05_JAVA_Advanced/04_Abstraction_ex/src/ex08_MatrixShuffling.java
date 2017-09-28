import java.util.Scanner;

public class ex08_MatrixShuffling {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer rows = scanner.nextInt();
		Integer cols = scanner.nextInt();
		
		String[][] matrix = new String[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = scanner.next();
			}
		}
		
		scanner.nextLine();
		
		String command = scanner.nextLine();
		while (!command.equals("END")) {
			
			String[] tokens = command.split("\\s+");
			if (!tokens[0].equals("swap")) {
				System.out.println("Invalid input!");
				command = scanner.nextLine();
				continue;
			}
			
			Integer row1 = null;
			Integer col1 = null;
			Integer row2 = null;
			Integer col2 = null;
			
			try {
				row1 = Integer.parseInt(tokens[1]);
				col1 = Integer.parseInt(tokens[2]);
				row2 = Integer.parseInt(tokens[3]);
				col2 = Integer.parseInt(tokens[4]);
			} catch (Exception e) {
				System.out.println("Invalid input!");
				command = scanner.nextLine();
				continue;
			}
			
			if (isValidCoordinates(rows, cols, row1, row2, col1, col2)) {
				swapElements(matrix, row1, row2, col1, col2);
			} else {
				System.out.println("Invalid input!");
			}

			command = scanner.nextLine();
			
		}
		
		
		scanner.close();
		
	}

	private static Boolean isValidCoordinates(Integer rows, Integer cols, Integer row1, Integer row2, Integer col1, Integer col2) {
		
		if (row1 >= rows || row1 < 0 || row2 >= rows || row2 < 0
				|| col1 >= cols || col1 < 0 || col2 >= cols || col2 < 0) {
			return false;
		} else {
			return true;
		}
		
	}

	private static void swapElements(String[][] matrix, Integer row1, Integer row2, Integer col1, Integer col2) {
		
		String temp = matrix[row2][col2];
		matrix[row2][col2] = matrix[row1][col1];
		matrix[row1][col1] = temp;
		
		printMatrix(matrix);
		
	}

	private static void printMatrix(String[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			
		}
		
	}

}
