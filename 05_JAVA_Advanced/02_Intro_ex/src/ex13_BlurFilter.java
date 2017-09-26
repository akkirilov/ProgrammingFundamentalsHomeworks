import java.util.Scanner;

public class ex13_BlurFilter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer blurAmount = scanner.nextInt();
		Integer rows = scanner.nextInt();
		Integer cols = scanner.nextInt();
		
		Long[][] matrix = new Long[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = scanner.nextLong();
			}
		}
		
		Integer posR = scanner.nextInt();
		Integer posC = scanner.nextInt();
		
		scanner.close();
		
		Integer startRow = posR - 1;
		if (startRow < 0) {
			startRow = 0;
		}
		
		Integer endRow = posR + 1;
		if (endRow > rows - 1) {
			endRow = rows - 1;
		}
		
		Integer startCol = posC - 1;
		if (startCol < 0) {
			startCol = 0;
		}
		
		Integer endCol = posC + 1;
		if (endCol > cols - 1) {
			endCol = cols - 1;
		}
		
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				matrix[i][j] += blurAmount;
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
