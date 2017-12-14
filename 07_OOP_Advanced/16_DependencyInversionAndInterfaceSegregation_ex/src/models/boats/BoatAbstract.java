package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.IBoat;
import contracts.IModelable;

public abstract class BoatAbstract implements IBoat, IModelable {

	private String model;
	private int weight;
	
	protected BoatAbstract(String model, int weight) {
		this.setModel(model);
		this.setWeight(weight);
	}
	
	private void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
        this.model = model;
    }
	
	private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

}
