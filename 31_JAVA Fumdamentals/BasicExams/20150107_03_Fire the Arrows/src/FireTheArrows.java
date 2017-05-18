import java.util.Scanner;

public class FireTheArrows {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int rows = Integer.parseInt(scanner.nextLine());
		String tokens = scanner.nextLine().trim();
		int cols = tokens.length();
		
		char[][] field = new char[rows][cols];
		for (int r = 0; r < rows; r++) {			
			for (int c = 0; c < cols; c++) {
				field[r][c] = tokens.charAt(c);
			}
			
			if (r != rows - 1) {
				tokens = scanner.nextLine().trim();
			}
		}
		
		boolean moveUp = true;
		boolean moveDown = true;
		boolean moveLeft = true;
		boolean moveRight = true;
		while (moveUp || moveDown || moveLeft || moveRight) {			
			moveUp = false;
			moveDown = false;
			moveLeft = false;
			moveRight = false;
			
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (field[r][c] == '^' && r != 0 && field[r - 1][c] == 'o') {
						field[r - 1][c] = '^';
						field[r][c] = 'o';
						moveUp = true;
					}
					else if (field[r][c] == '<' && c != 0 && field[r][c - 1] == 'o') {
						field[r][c - 1] = '<';
						field[r][c] = 'o';
						moveLeft = true;
					}
					else if (field[r][c] == 'v' && r != rows - 1 && field[r + 1][c] == 'o') {
						field[r + 1][c] = 'v';
						field[r][c] = 'o';
						moveDown = true;
					}
					else if (field[r][c] == '>' && c != cols - 1 && field[r][c + 1] == 'o') {
						field[r][c + 1] = '>';
						field[r][c] = 'o';
						moveRight = true;
					}
				}
			}
		}
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				System.out.print(field[r][c]);
			}
			System.out.println();
		}
	}
}