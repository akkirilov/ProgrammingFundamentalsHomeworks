package models.boats;

import contracts.IBoat;
import contracts.IEngine;
import contracts.IModelable;
import contracts.IRace;
import utilities.Validator;

public final class Yacht extends BoatAbstract implements IBoat, IModelable {
   
    private static final double OCEAN_SPEED_DIVIDER = 2d;
    private static final boolean IS_MOTOR_BOAT = true;
    
    private int cargoWeight;
    private IEngine engine;

    public Yacht(String model, int weight, int cargoWeight, IEngine engine) {
        super(model, weight);
        this.setCargoWeight(cargoWeight);
        this.engine = engine;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double getRaceSpeed(IRace race) {
        return engine.getOutput() - (super.getWeight() + this.cargoWeight) 
        		+ (race.getOceanCurrentSpeed() / OCEAN_SPEED_DIVIDER);
    }
    
    @Override
	public boolean isMotorBoat() {
		return IS_MOTOR_BOAT;
	}
	
}
