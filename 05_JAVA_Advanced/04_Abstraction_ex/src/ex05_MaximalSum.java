import java.util.Scanner;

public class ex05_MaximalSum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s+");

		Integer rows = Integer.parseInt(input[0]);
		Integer cols = Integer.parseInt(input[1]);
		Integer[][] matrix = new Integer[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		scanner.close();
		
		Integer startRow = -1;
		Integer startCol = -1;
		Integer maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < rows - 2; i++) {
			for (int j = 0; j < cols - 2; j++) {
				Integer sum = count3x3Sum(matrix, i, j);
				if (sum > maxSum) {
					maxSum = sum;
					startRow = i;
					startCol = j;
				}
			}
		}
		
		printMaxSum(matrix, startRow, startCol, maxSum);
		
	}

	private static void printMaxSum(Integer[][] matrix, Integer startRow, Integer startCol, Integer maxSum) {
		
		System.out.println("Sum = " + maxSum);
		
		for (int i = startRow; i <= startRow + 2; i++) {
			
			for (int j = startCol; j <= startCol + 2; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			
		}
		
	}

	private static Integer count3x3Sum(Integer[][] matrix, int row, int col) {
		
		Integer sum = 0;
		
		for (int i = row; i <= row + 2; i++) {
			
			for (int j = col; j <= col + 2; j++) {
				sum += matrix[i][j];
			}
			
		}
		
		return sum;
		
	}

}
