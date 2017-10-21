import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e02_JediGalaxy {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] matrixArgs = reader.readLine().split("\\s+");
		int rows = Integer.parseInt(matrixArgs[0]);
		int cols = Integer.parseInt(matrixArgs[1]);
		long count = 0;
		long[][] universe = new long[rows][cols];
		for (int r = 0; r < universe.length; r++) {
			for (int c = 0; c < universe[r].length; c++) {
				universe[r][c] = count;
				count++;
			}
		}

		long total = 0L;
		String command = reader.readLine();
		while (!"Let the Force be with you".equals(command)) {
			String[] ivoCoordinates = command.split("\\s+");
			String[] evilCoordinates = reader.readLine().split("\\s+"); // check

			if (evilCoordinates[0].equals("Let")) {
				break;
			}

			int ivoRow = Integer.parseInt(ivoCoordinates[0]);
			int ivoCol = Integer.parseInt(ivoCoordinates[1]);
			int darkRow = Integer.parseInt(evilCoordinates[0]);
			int darkCol = Integer.parseInt(evilCoordinates[1]);

			if (darkRow >= rows) {
				int shiftValue = darkRow - rows + 1;
				darkRow -= shiftValue;
				darkCol -= shiftValue;
			}
			if (darkCol >= cols) {
				int shiftValue = darkCol - cols + 1;
				darkRow -= shiftValue;
				darkCol -= shiftValue;
			}
			while (darkRow >= 0 && darkCol >= 0) {
				universe[darkRow][darkCol] = 0;
				darkRow--;
				darkCol--;
			}

			if (ivoRow >= rows) {
				int shiftValue = ivoRow - rows + 1;
				ivoRow -= shiftValue;
				ivoCol += shiftValue;
			}
			if (ivoCol < 0) {
				int shiftValue = Math.abs(ivoCol);
				ivoRow -= shiftValue;
				ivoCol += shiftValue;
			}
			while (ivoRow >= 0 && ivoCol < cols) {
				total += universe[ivoRow][ivoCol];
				ivoRow--;
				ivoCol++;
			}
			command = reader.readLine();
		}

		System.out.println(total);

		reader.close();

	}

}
