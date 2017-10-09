import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ex04_TruckTour {

	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayDeque<Integer> fuel = new ArrayDeque<>();
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bfr.readLine());
		for (Long i = 0L; i < n; i++) {
			int[] tokens = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			fuel.addLast(tokens[0] - tokens[1]);
		}

		bfr.close();

		int index = 0;
		while (true) {
			
			boolean success = true;
			int currFuel = fuel.removeFirst();

			if (currFuel >= 0) {
				int petrolInTank = currFuel;
				int nextFuel = currFuel;
				for (int j = 1; j < n; j++) {
					nextFuel = fuel.removeFirst();
					fuel.addLast(nextFuel);
					petrolInTank += nextFuel;
					if (petrolInTank < 0) {
						success = false;
						for (int i = j + 1; i < n; i++) {
							fuel.addLast(fuel.removeFirst());
						}
						break;
					}
				}
				if (success) {
					System.out.println(index);
					return;
				}
			}
			
			fuel.addLast(currFuel);
			index++;
				
		}

	}

}