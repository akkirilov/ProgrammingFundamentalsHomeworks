package nfs.factories;

import nfs.entities.car.Car;
import nfs.entities.car.PerformanceCar;
import nfs.entities.car.ShowCar;

public class CarFactory {
	
	public static Car getCar (String type, String brand, String model, int yearOfProduction, 
			int horsepower, int acceleration, int suspension, int durability) {
		
		switch (type) {
		case "Show":
			return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
		case "Performance":
			return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
		}
		
		return null;
	}

}
