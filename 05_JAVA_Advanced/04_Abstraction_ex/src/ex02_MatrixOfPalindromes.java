import java.util.Scanner;

public class ex02_MatrixOfPalindromes {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s+");
		
		scanner.close();
		
		Integer rows = Integer.parseInt(input[0]);
		Integer cols = Integer.parseInt(input[1]);
		
		String[][] matrix = fillMatrix(rows, cols);
		
		printMatrix(matrix);
		
	}
	
	private static void printMatrix(String[][] matrix) {
				
		for (int row = 0; row < matrix.length; row++) {
			
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
			
		}
		
	}

	private static String[][] fillMatrix(Integer rows, Integer cols) {
		
		String[][] matrix = new String[rows][cols];
	
		for (int i = 0; i < rows; i++) {
			char side = (char) ('a' + i);
			for (int j = 0; j < cols; j++) {
				char middle = (char) (side + j);
				matrix[i][j] = "" + side + middle + side;
			}
		}
		
		return matrix;
	
	}

}
