package models.boatEngines;

import contracts.IEngine;
import contracts.IModelable;
import utilities.Constants;
import utilities.Validator;

public abstract class EngineAbstract implements IEngine, IModelable {
	
    private String model;
    private int horsepower;
    private int displacement;
    
    protected EngineAbstract(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }
    
    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatEngineModelLength);
        this.model = model;
    }
    
    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }
    
    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public int getHorsepower() {
		return this.horsepower;
	}

	@Override
	public int getDisplacement() {
		return this.displacement;
	}

}
