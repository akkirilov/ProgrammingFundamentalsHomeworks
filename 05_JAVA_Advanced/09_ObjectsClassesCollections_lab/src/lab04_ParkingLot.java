import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class lab04_ParkingLot {

	public static void main(String[] args) throws IOException {
		
		Set<String> cars = new HashSet<>();
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = bfr.readLine().split(",\\s+");
		while (!tokens[0].equals("END")) {
			
			if (tokens[0].equals("IN")) {
				cars.add(tokens[1]);
			} else if (tokens[0].equals("OUT")) {
				cars.remove(tokens[1]);
			}
			
			tokens = bfr.readLine().split(",\\s+");
			
		}
		
		bfr.close();
		
		if (cars.size() == 0) {
			System.out.println("Parking Lot is Empty");
			return;
		}
		
		for (String car : cars) {
			System.out.println(car);
		}
		
	}

}
