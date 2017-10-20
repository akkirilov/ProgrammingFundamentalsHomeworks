import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class e03_ChessKnight {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[][] board = new String[8][];
		for (int i = 0; i < board.length; i++) {
			board[i] = reader.readLine().split("\\|");
		}
		reader.readLine();
		
		String tokens = reader.readLine();
		int fromRow;
		int fromCol;
		int toRow;
		int toCol;
		boolean makeMove;
		int invalidMoves = 0;
		int outMoves = 0;
		List<String> figures = new ArrayList<>();
		while (!tokens.equals("END")) {
			
			makeMove = true;
			fromRow = Integer.parseInt(tokens.charAt(0) + "");
			fromCol = Integer.parseInt(tokens.charAt(1) + "");
			toRow = Integer.parseInt(tokens.charAt(6) + "");
			toCol = Integer.parseInt(tokens.charAt(7) + "");
			
			if ((Math.abs(fromRow - toRow) != 2 || (Math.abs(fromCol - toCol) != 1))
					&& (Math.abs(fromRow - toRow) != 1 || (Math.abs(fromCol - toCol) != 2))) {
				invalidMoves++;
				makeMove = false;
			} else if (!validateNextPosition(toRow) 
					|| !validateNextPosition(toCol)) {
				outMoves++;
				makeMove = false;
			}
			
			tokens = reader.readLine();
			
			if (!makeMove) {
				continue;
			} else if (!board[toRow][toCol].equals("") 
					&& !board[toRow][toCol].equals(" ")) {
				figures.add(board[toRow][toCol]);
			}
			
		}
		
		reader.close();
		
		System.out.println("Pieces take: " + figures.toString().replaceAll("\\[|\\]", ""));
		System.out.println("Invalid moves: " + invalidMoves);
		System.out.println("Board out moves: " + outMoves);
		
		
	}

	private static boolean validateNextPosition(int pos) {
		if (pos < 0 || pos > 7) {
			return false;
		}
		return true;
	}

}
