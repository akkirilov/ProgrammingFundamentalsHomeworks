package carShop;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Seat("Leon", "Gray", 55, 550d, "Spain"));
		cars.add(new Audi("S8", "Black", 410, 3, 99.5));
		
		for (Car car : cars) {
			System.out.println(car.toString());
			System.out.println();
		}
		
	}
	
}
