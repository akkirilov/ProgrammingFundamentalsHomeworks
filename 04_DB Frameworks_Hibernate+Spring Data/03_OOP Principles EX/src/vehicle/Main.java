package vehicle;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] info = scanner.nextLine().split("\\s+");
		Vehicle car = new Car(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
		
		info = scanner.nextLine().split("\\s+");
		Vehicle truck = new Truck(Double.parseDouble(info[1]), Double.parseDouble(info[2]));
		
		DecimalFormat df = new DecimalFormat("#.###########");
		
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			info = scanner.nextLine().split("\\s+");
			if (info.length < 3) {
				continue;
			}
			if (info[1].trim().equals("Car")) {
				if (info[0].trim().equals("Drive")) {
					if(Double.parseDouble(info[2]) * car.getFuelConsumption() > car.getFuelQuantity() ){
						System.out.println("Car needs refueling");
					} else {
						car.addDistance(Double.parseDouble(info[2]));
						car.drive(Double.parseDouble(info[2]) * car.getFuelConsumption());
						System.out.printf("Car travelled %s km%n", df.format(Double.parseDouble(info[2])));
					}
				} else {
					car.refuel(Double.parseDouble(info[2]));
				}
			} else {
				if (info[0].trim().equals("Drive")) {
					if(Double.parseDouble(info[2]) * truck.getFuelConsumption() > truck.getFuelQuantity() ){
						System.out.println("Truck needs refueling");
					} else {
						truck.addDistance(Double.parseDouble(info[2]));
						truck.drive(Double.parseDouble(info[2]) * truck.getFuelConsumption());
						System.out.printf("Truck travelled %s km%n", df.format(Double.parseDouble(info[2])));
					}
				} else {
					truck.refuel(Double.parseDouble(info[2]));
				}
			}
		}
		scanner.close();
	
		System.out.printf("Car: %.2f%n", car.getFuelQuantity());
		System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
		
		
	}

}
