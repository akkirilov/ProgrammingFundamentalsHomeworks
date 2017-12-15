package models.boats;

import contracts.IBoat;
import contracts.IModelable;
import contracts.IRace;
import utilities.Constants;

public final class SailBoat extends BoatAbstract implements IBoat, IModelable {
   
    private static final double OCEAN_SPEED_DIVIDER = 2d;
    private static final double SAIL_EFFICIENCY_DIVIDER = 100d;
    private static final boolean IS_MOTOR_BOAT = false;
    
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
    	this.setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double getRaceSpeed(IRace race) {
    	return ((race.getWindSpeed() * (this.sailEfficiency / SAIL_EFFICIENCY_DIVIDER)) 
    			- super.getWeight() + (race.getOceanCurrentSpeed() / OCEAN_SPEED_DIVIDER));
    }

	@Override
	public boolean isMotorBoat() {
		return IS_MOTOR_BOAT;
	}
	
}
