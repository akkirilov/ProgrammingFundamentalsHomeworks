package models.boatEngines;

import contracts.IEngine;
import contracts.IModelable;

public class Sterndrive extends EngineAbstract implements IModelable, IEngine {
    
	private static final int MULTIPLIER = 7;

    public Sterndrive(String model, int horsepower, int displacement) {
    	super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
    }

}
