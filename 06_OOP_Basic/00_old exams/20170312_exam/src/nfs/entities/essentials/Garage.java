package nfs.entities.essentials;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import nfs.entities.car.Car;

public class Garage {
	
	private Map<Integer, Car> parkedCars;

	public Garage() {
		super();
		this.parkedCars = new HashMap<>();
	}
	
	public Map<Integer, Car> getParkedCars() {
		return Collections.unmodifiableMap(parkedCars);
	}

	public void park(int id, Car car) {
		if (!parkedCars.containsKey(id)) {
			parkedCars.put(id, car);
		}
	}
	
	public Car unpark(int id) {
		if (parkedCars.containsKey(id)) {
			return parkedCars.remove(id);
		}
		return null;
	}
	
	public void modify(int tuneIndex, String addOn) {
		for (Map.Entry<Integer, Car> entry : parkedCars.entrySet()) {
			entry.getValue().modify(tuneIndex, addOn);
		}
	}

	@Override
	public String toString() {
		return String.format("Garage [parkedCars=%s]", parkedCars);
	}

}
