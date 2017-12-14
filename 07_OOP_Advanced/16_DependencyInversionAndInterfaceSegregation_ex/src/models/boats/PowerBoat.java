package models.boats;

import contracts.IBoat;
import contracts.IEngine;
import contracts.IModelable;
import contracts.IRace;

import java.util.List;

public final class PowerBoat extends BoatAbstract implements IBoat, IModelable {
   
    private static final double OCEAN_SPEED_DIVIDER = 5d;

    private List<IEngine> engines;

    public PowerBoat(String model, int weight, List<IEngine> engines) {
        super(model, weight);
        this.engines = engines;
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
