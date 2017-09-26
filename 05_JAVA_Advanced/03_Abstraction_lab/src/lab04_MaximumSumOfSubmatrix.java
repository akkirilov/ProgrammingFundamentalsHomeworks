import java.util.Arrays;
import java.util.Scanner;

public class lab04_MaximumSumOfSubmatrix {

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
		
		Integer maxSum = Integer.MIN_VALUE;
		Integer sRow = -1;
		Integer sCol = -1;
		for (int i = 0; i < rows - 1; i++) {
			
			for (int j = 0; j < cols - 1; j++) {
				Integer temp = matrix[i][j] + matrix[i][j + 1] 
						+ matrix[i + 1][j] + matrix[i + 1][j + 1];
				if (temp > maxSum) {
					maxSum = temp;
					sRow = i;
					sCol = j;
				}
			}
			
		}
		
		System.out.printf("%d %d%n%d %d%n%d%n", 
				matrix[sRow][sCol], matrix[sRow][sCol + 1], 
				matrix[sRow + 1][sCol], matrix[sRow + 1][sCol + 1], 
				maxSum);
		
	}

}
