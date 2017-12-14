package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.IBoat;
import contracts.IEngine;
import contracts.IModelable;
import contracts.IRace;

import java.util.List;

public final class Boat extends BoatAbstract implements IBoat, IModelable {
   
    private static final double OCEAN_SPEED_DIVIDER = 5d;
    
	private int oars;
    private int sailEfficiency;
    private int cargoWeight;
    private List<IEngine> engines;

    public Boat(String model, int weight, int sailEfficiency, int oars, int cargoWeight, List<IEngine> engines) {
        super(model, weight);
    	this.setSailEfficiency(sailEfficiency);
        this.setCargoWeight(cargoWeight);
        this.setOars(oars);
        this.engines = engines;
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if (sailEfficiency < 1 || sailEfficiency > 100) {
            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
        }
        this.sailEfficiency = sailEfficiency;
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double getRaceSpeed(IRace race) {
    	int enginesOutput = 0;
    	for (IEngine e : engines) {
    		enginesOutput += e.getOutput();
		}
        return enginesOutput - super.getWeight() + (race.getOceanCurrentSpeed() / OCEAN_SPEED_DIVIDER);
    }
    
}


