import java.util.Scanner;

public class ex06_SequenceInMatrix {

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

		String seqWord = "";
		Integer seqCount  = 0;
		
		for (int i = 0; i < rows; i++) {
			
			Integer seqCurr = 0;
			for (int j = 0; j < cols; j++) {

				seqCurr = checDiagonal(matrix, i, j);
				if (seqCurr >= seqCount) {
					seqCount = seqCurr;
					seqWord = matrix[i][j].toLowerCase();
				}
				
				seqCurr = checkCol(matrix, i, j);
				if (seqCurr >= seqCount) {
					seqCount = seqCurr;
					seqWord = matrix[i][j].toLowerCase();
				}
				
			}
			
		}
		
		print(seqWord, seqCount);
		
	}

	private static void print(String seqWord, Integer seqCount) {
		
		for (int i = 0; i < seqCount; i++) {
			
			System.out.print(seqWord);
			if (i != seqCount - 1) {
				System.out.print(", ");
			}
			
		}
		
		System.out.println();
		
	}

	private static Integer checkCol(String[][] matrix, int row, int col) {

		Integer tempSum = 0;
		String tempWord = matrix[row][col];
		
		for (;row < matrix.length; row++) {

			if (tempWord.equals(matrix[row][col])) {
				tempSum++;
			} else {
				return tempSum;
			}
			
		}
		
		return tempSum;
		
	}

	private static Integer checDiagonal(String[][] matrix, int row, int col) {
		
		Integer tempSum = 1;
		String tempWord = matrix[row][col];
		
		for (int k = row; k < Math.min(matrix.length-1, matrix[row].length-1); k++) {
            if(tempWord.equals(matrix[k+1][k+1])){
            	tempSum++;
            } else {
                break;
            }
        }
		
		return tempSum;
		
	}

}
