import java.util.Scanner;

public class ex01_FillTheMatrix {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split(",\\s+");
		
		scanner.close();
		
		Integer size = Integer.parseInt(input[0]);
		String type = input[1];
		
		Integer[][] matrix = new Integer[size][size];
		
		switch (type) {
		case "A":
			matrix = fillMatrixA(size);
			break;
		case "B":
			matrix = fillMatrixB(size);
			break;
		default:
			break;
		}
		
		printMatrix(matrix);
		
	}

	private static Integer[][] fillMatrixA(Integer size) {
		
		Integer num = 1;
		Integer[][] matrix = new Integer[size][size];
		
		for (int col = 0; col < size; col++) {
			
			for (int row = 0; row < size; row++) {
				matrix[row][col] = num;
				num++;
			}
			
		}
		
		return matrix;
		
	}

	private static Integer[][] fillMatrixB(Integer size) {

		Integer num = 1;
		Boolean toDown = true;
		Integer[][] matrix = new Integer[size][size];
		
		for (int col = 0; col < size; col++) {
			
			if (toDown) {
				for (int row = 0; row < size; row++) {
					matrix[row][col] = num;
					num++;
				}
				toDown = false;
			} else {
				for (int row = size - 1; row >= 0; row--) {
					matrix[row][col] = num;
					num++;
				}
				toDown = true;
			}
			
		}
		
		return matrix;
		
	}

	private static void printMatrix(Integer[][] matrix) {
		
		Integer size = matrix.length;
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		
	}

}
