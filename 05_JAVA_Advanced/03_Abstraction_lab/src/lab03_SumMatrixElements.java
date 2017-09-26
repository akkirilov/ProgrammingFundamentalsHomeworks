import java.util.Arrays;
import java.util.Scanner;

public class lab03_SumMatrixElements {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] size = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
		
		Integer rows = size[0];
		Integer cols = size[1];
		int[][] matrix = new int[rows][];
		for (int i = 0; i < rows; i++) {
			matrix[i] = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		
		scanner.close();
		
		Integer sum = calculate(matrix, rows, cols);
		
		System.out.println(rows);
		System.out.println(cols);
		System.out.println(sum);
		
	}

	private static Integer calculate(int[][] matrix, Integer rows, Integer cols) {
		
		Integer sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum += matrix[i][j];
			}
		}
		
		return sum;
		
	}

}
