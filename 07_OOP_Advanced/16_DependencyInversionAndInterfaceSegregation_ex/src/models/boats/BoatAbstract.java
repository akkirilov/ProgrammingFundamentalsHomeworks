package models.boats;

import contracts.IBoat;
import contracts.IModelable;
import utilities.Constants;
import utilities.Validator;

public abstract class BoatAbstract implements IBoat, IModelable {

	private String model;
	private int weight;
	
	protected BoatAbstract(String model, int weight) {
		this.setModel(model);
		this.setWeight(weight);
	}
	
	private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }
	
	private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

	@Override
	public String getModel() {
		return this.model;
	}

	protected int getWeight() {
		return this.weight;
	}

}
