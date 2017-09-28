import java.util.Scanner;

public class ex07_CollectTheCoins {
	
	private static Integer P_ROW = 0;
	private static Integer P_COL = 0;
	private static Integer COINS = 0;
	private static Integer WALLS = 0;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] matrix = new char [4][];
		for (int i = 0; i < 4; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		char[] commands = scanner.nextLine().toCharArray();;

		scanner.close();
				
		for (int i = 0; i < commands.length; i++) {
			
			switch (commands[i]) {
			case '>':
				moveRight(matrix);
				break;
			case 'V':
				moveDown(matrix);
				break;
			case '<':
				moveLeft(matrix);
				break;
			case '^':
				moveUp(matrix);
				break;
			default:
				break;
			}
			
		}
		
		System.out.printf("Coins = %d%nWalls = %d%n", COINS, WALLS);
		
	}

	private static void moveUp(char[][] matrix) {

		if (P_ROW - 1 < 0 
				|| matrix[P_ROW - 1].length <= P_COL) {
			WALLS++;
			return;
		} else {
			P_ROW--;
		}
		
		if (matrix[P_ROW][P_COL] == '$') {
			COINS++;
		}
		
	}

	private static void moveDown(char[][] matrix) {
				
		if (P_ROW + 1 >= matrix.length 
				|| matrix[P_ROW + 1].length <= P_COL) {
			WALLS++;
			return;
		} else {
			P_ROW++;
		}
		
		if (matrix[P_ROW][P_COL] == '$') {
			COINS++;
		}
		
	}

	private static void moveLeft(char[][] matrix) {
		
		if (P_COL - 1 < 0) {
			WALLS++;
			return;
		} else {
			P_COL--;
		}
		
		if (matrix[P_ROW][P_COL] == '$') {
			COINS++;
		}
		
	}

	private static void moveRight(char[][] matrix) {
		
		if (P_COL + 1 >= matrix[P_ROW].length) {
			WALLS++;
			return;
		} else {
			P_COL++;
		}
		
		if (matrix[P_ROW][P_COL] == '$') {
			COINS++;
		}
		
	}

}
