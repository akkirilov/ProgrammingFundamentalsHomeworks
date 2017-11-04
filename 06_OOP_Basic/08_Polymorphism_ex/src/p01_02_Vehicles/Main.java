package p01_02_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = reader.readLine().split("\\s+");
		Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
		
		tokens = reader.readLine().split("\\s+");
		Vehicle truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
		
		tokens = reader.readLine().split("\\s+");
		Vehicle bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
		
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			
			tokens = reader.readLine().split("\\s+");
			switch (tokens[1]) {
			case "Car":
				executeCommand(tokens, car);
				break;
			case "Truck":
				executeCommand(tokens, truck);
				break;
			case "Bus":
				executeCommand(tokens, bus);
				break;
			}
			
		}
		
		reader.close();
		
		System.out.println(car);
		System.out.println(truck);
		System.out.println(bus);

	}
	
	private static void executeCommand (String[] tokens, Vehicle vehicle) {
		if (tokens[0].equals("Drive")) {
			System.out.println(vehicle.drive(Double.parseDouble(tokens[2])));
		} else if (tokens[0].equals("DriveEmpty")) {
			System.out.println(((Bus) vehicle).driveEmpty(Double.parseDouble(tokens[2])));
		} else {
			vehicle.refuel(Double.parseDouble(tokens[2]));
		}
	}

}
