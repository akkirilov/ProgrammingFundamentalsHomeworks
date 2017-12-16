package models.boatEngines;

import contracts.IEngine;
import contracts.IModelable;

public class Jet extends EngineAbstract implements IEngine, IModelable {
	
    private static final int MULTIPLIER = 5;
    
    private int output;

    public Jet(String model, int horsepower, int displacement) {
    	super(model, horsepower, displacement);
    	this.setOutput();
    }

    private void setOutput() {
		this.output = (super.getHorsepower() * MULTIPLIER) + super.getDisplacement();
	}

	@Override
    public int getOutput() {
        return output;
    }
    
}
