package models.boatEngines;

import contracts.IEngine;
import contracts.IModelable;

public class Sterndrive extends EngineAbstract implements IModelable, IEngine {
    
	private static final int MULTIPLIER = 7;
	
	private int output;

    public Sterndrive(String model, int horsepower, int displacement) {
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
