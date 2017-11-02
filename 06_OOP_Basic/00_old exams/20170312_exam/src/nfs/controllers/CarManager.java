package nfs.controllers;

import java.util.HashMap;
import java.util.Map;

import nfs.entities.car.Car;
import nfs.entities.essentials.Garage;
import nfs.entities.race.Race;
import nfs.factories.CarFactory;
import nfs.factories.RaceFactory;

public class CarManager {

	private Map<Integer, Car> cars;
	private Map<Integer, Race> races;
	private Garage garage;

	public CarManager() {
		this.cars = new HashMap<>();
		this.races = new HashMap<>();
		this.garage = new Garage();
	}

	public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
			int acceleration, int suspension, int durability) {
		Car tempCar;
		if ((tempCar = CarFactory.getCar(type, brand, model, yearOfProduction, horsepower, acceleration, suspension,
				durability)) != null) {
			cars.put(id, tempCar);
		}
	}

	public String check(int id) {
		if (cars.containsKey(id)) {
			return cars.get(id).toString();
		} else {
			return garage.getParkedCars().get(id).toString();
			}
	}

	public void open(int id, String type, int length, String route, int prizePool) {
		Race tempRace;
		if ((tempRace = RaceFactory.getRace(type, length, route, prizePool)) != null) {
			races.put(id, tempRace);
		}
	}

	public void participate(int carId, int raceId) {
		if (!garage.getParkedCars().containsKey(carId) && races.containsKey(raceId)) {
			races.get(raceId).addParticipant(carId, cars.get(carId));
		}
	}

	public String start(int id) {
		
		String res;
		if (!races.containsKey(id)) {
			res = "\r\n";
		} else if (races.get(id).getParticipants().size() == 0) {
			res = "Cannot start the race with zero participants.\r\n";
		} else {
			res = races.remove(id).toString();
		}
		
		return res;
	}

	public void park(int id) {
		if (races.entrySet().stream().anyMatch(x -> x.getValue().getParticipants().containsKey(id))) {
			return;
		}
		garage.park(id, cars.remove(id));
	}

	public void unpark(int id) {
		if (garage.getParkedCars().containsKey(id)) {
			cars.put(id, garage.unpark(id));
		}
	}
	
	 public void tune(int tuneIndex, String addOn) {
		 
		 garage.modify(tuneIndex, addOn);
		 
	 }

}
