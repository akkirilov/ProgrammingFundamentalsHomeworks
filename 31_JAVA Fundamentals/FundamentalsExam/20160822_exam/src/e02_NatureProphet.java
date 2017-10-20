import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class e02_NatureProphet {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = reader.readLine().split("\\s+");
		int row = Integer.parseInt(tokens[0]);
		int col = Integer.parseInt(tokens[1]);
		int[][] garden = new int[row][col];
		List<String> positions = new ArrayList<>();
		
		tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("Bloom")) {
			
			row = Integer.parseInt(tokens[0]);
			col = Integer.parseInt(tokens[1]);
			positions.add(row + " " + col);
			garden[row][col]++;
			
			tokens = reader.readLine().split("\\s+");
		}
		
		reader.close();
		
		Collections.sort(positions);
		for (int i = 0; i < positions.size(); i++) {
			tokens = positions.get(i).split("\\s+");
			row = Integer.parseInt(tokens[0]);
			col = Integer.parseInt(tokens[1]);
			bloomFlowers(garden, row, col);
		}
		
		for (int r = 0; r < garden.length; r++) {
			for (int c = 0; c < garden[r].length; c++) {
				System.out.print(garden[r][c] + " ");
			}
			System.out.println();
		}
		
	}

	private static void bloomFlowers(int[][] garden, int r, int c) {
		for (int i = 0; i < garden[r].length; i++) {
			if (i != c) {
				garden[r][i]++;
			}
		}
		for (int i = 0; i < garden.length; i++) {
			if (i != r) {
				garden[i][c]++;
			}
		}
	}

}
