package models.boatEngines;

import contracts.IEngine;
import contracts.IModelable;

public class JetEngine extends EngineAbstract implements IEngine, IModelable {
	
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
    	super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        return (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
    }
    
}
