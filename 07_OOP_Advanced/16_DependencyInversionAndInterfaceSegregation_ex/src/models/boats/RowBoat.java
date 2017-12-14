package models.boats;

import Utility.Validator;
import contracts.IBoat;
import contracts.IModelable;
import contracts.IRace;

public final class RowBoat extends BoatAbstract implements IBoat, IModelable {
   
    private static final int OARS_MULTILIER = 100;
    
	private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double getRaceSpeed(IRace race) {
        return (this.oars * OARS_MULTILIER) - super.getWeight() + race.getOceanCurrentSpeed();
    }
    
}
