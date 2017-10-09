import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ex04_TruckTour {

	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayDeque<String> data = new ArrayDeque<>();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bfr.readLine());
		for (Long i = 0L; i < n; i++) {
			data.addLast(bfr.readLine());
		}

		bfr.close();
		
		int index = 0;
		while (true) {
			
			boolean success = true;

			String currLine = data.removeFirst();
			String[] tokens = currLine.split("\\s+");
			int currPetrol = Integer.parseInt(tokens[0]);
			int nextPump = Integer.parseInt(tokens[1]);
			
			int petrolInTank = currPetrol - nextPump;
			if (petrolInTank >= 0) {
				for (int j = 1; j < n; j++) {
					
					String nextLine = data.removeFirst();
					String[] tokens2 = nextLine.split("\\s+");
					currPetrol = Integer.parseInt(tokens2[0]);
					nextPump = Integer.parseInt(tokens2[1]);
					
					petrolInTank += currPetrol - nextPump;
					if (petrolInTank < 0) {
						
						success = false;
						for (int i = j + 1; i < tokens2.length; i++) {
							data.addLast(data.removeFirst());
						}
						break;
					}
					if (success) {
						System.out.println(index);
						return;
					}
					
				}
				
			}			

			data.addLast(currLine);

		
			index++;
		}

	}

}