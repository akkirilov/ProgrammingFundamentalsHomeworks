import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ex12_VehiclePark {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		List<String> cars = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
		
		Integer counter = 0;
		String[] command = scanner.nextLine().split("\\s+");
		while (!command[0].equals("End")) {
			
			String type = command[0];
			Integer seatsCount = Integer.parseInt(command[2]);
			String requestedCar = getRequestedCar(type, seatsCount);
			
			if (cars.contains(requestedCar)) {
				cars.remove(requestedCar);
				Integer cost = countCarCost(requestedCar, seatsCount);
				System.out.printf("Yes, sold for %d$%n", cost);
				counter++;
			} else {
				System.out.println("No");
			}
			
			command = scanner.nextLine().split("\\s+");
			
		}
		
		scanner.close();
		
		System.out.printf("Vehicles left: %s%n", String.join(", ", cars));
		System.out.printf("Vehicles sold: %d%n", counter);
		
	}

	private static Integer countCarCost(String requestedCar, Integer seatsCount) {
		
		return seatsCount * requestedCar.charAt(0);
		
	}

	private static String getRequestedCar(String type, Integer seatsCount) {
		
		switch (type) {
		case "Bus":
			return "b" + seatsCount;
		case "Car":
			return "c" + seatsCount;
		case "Van":
			return "v" + seatsCount;
		}
		return null;
		
	}

}
