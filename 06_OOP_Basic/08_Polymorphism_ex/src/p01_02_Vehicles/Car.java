package p01_02_Vehicles;

public class Car extends Vehicle {

	public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption, tankCapacity);
	}

	@Override
	protected String drive(double distance) {
		if (super.getFuelQuantity() < (distance * (super.getFuelConsumption() + 0.9))) {
			return "Car needs refueling";
		} else {
			super.setFuelQuantity(super.getFuelQuantity() - (distance * (super.getFuelConsumption() + 0.9)));
			return "Car travelled " + super.PRINT_DISTANCE_FORMAT.format(distance) + " km";
		}
		
	}

	@Override
	protected void refuel(double fuelQuantity) {
		if (fuelQuantity <= 0) {
			System.out.println("Fuel must be a positive number");
		} else if (super.getFuelQuantity() + fuelQuantity > super.getTankCapacity()) {
			System.out.println("Cannot fit fuel in tank");
		} else {
			super.setFuelQuantity(super.getFuelQuantity() + fuelQuantity);
		}
	}

}
