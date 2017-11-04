package p01_02_Vehicles;

public class Truck extends Vehicle {

	public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption, tankCapacity);
	}

	@Override
	protected String drive(double distance) {
		if (super.getFuelQuantity() < (distance * (super.getFuelConsumption() + 1.6))) {
			return "Truck needs refueling";
		} else {
			super.setFuelQuantity(super.getFuelQuantity() - (distance * (super.getFuelConsumption() + 1.6)));
			return "Truck travelled " + super.PRINT_DISTANCE_FORMAT.format(distance) + " km";
		}
	}

	@Override
	protected void refuel(double fuelQuantity) {
		if (fuelQuantity <= 0) {
			System.out.println("Fuel must be a positive number");
		} else if (super.getFuelQuantity() + fuelQuantity > super.getTankCapacity()) {
			System.out.println("Cannot fit fuel in tank");
		} else {
			super.setFuelQuantity(super.getFuelQuantity() + (fuelQuantity * 0.95));
		}
	}

}
