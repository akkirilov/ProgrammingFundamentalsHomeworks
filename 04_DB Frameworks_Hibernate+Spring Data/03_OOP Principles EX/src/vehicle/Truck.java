package vehicle;

public class Truck extends Vehicle{

	public Truck(Double fuelQuantity, Double fuelConsumption) {
		super(fuelQuantity, fuelConsumption + 1.6);
	}

	@Override
	public void refuel(Double refuel) {
		super.refuel(refuel * 0.95);
	}
	
}
