package models.boats;

import contracts.IBoat;
import contracts.IModelable;
import contracts.IRace;
import utilities.Validator;

public final class RowBoat extends BoatAbstract implements IBoat, IModelable {
   
    private static final int OARS_MULTILIER = 100;
    private static final boolean IS_MOTOR_BOAT = false;
    
	private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double getRaceSpeed(IRace race) {
        return (this.oars * OARS_MULTILIER) - super.getWeight() + race.getOceanCurrentSpeed();
    }

	@Override
	public boolean isMotorBoat() {
		return IS_MOTOR_BOAT;
	}
    
}
