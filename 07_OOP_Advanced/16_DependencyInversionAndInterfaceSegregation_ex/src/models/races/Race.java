package models.races;

import contracts.IBoat;
import contracts.IRace;
import exeptions.DuplicateModelException;
import exeptions.IncorectBoatTypeException;
import utilities.Constants;
import utilities.Validator;

import java.util.ArrayList;
import java.util.List;

public class Race implements IRace {
    
	private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private Boolean allowsMotorBoats;
    private List<IBoat> registeredBoats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOceanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new ArrayList<>();
    }
    
    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }
    
    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    private void setOceanCurrentSpeed(int oseanCurrentSpeed) {
        this.oceanCurrentSpeed = oseanCurrentSpeed;
    }

    private void setAllowsMotorBoats(Boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }
    
    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return oceanCurrentSpeed;
    }

    @Override
    public void addParticipant(IBoat boat) throws DuplicateModelException, IncorectBoatTypeException {
    	for (IBoat iBoat : registeredBoats) {
			if (iBoat.getModel().equals(boat.getModel())) {
				throw new DuplicateModelException(Constants.DuplicateModelMessage);
			}
		}
        if (!this.allowsMotorBoats && boat.isMotorBoat()) {
        	throw new IncorectBoatTypeException(Constants.IncorrectBoatTypeMessage);
        	//throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.registeredBoats.add(boat);
    }

    @Override
    public List<IBoat> getParticipants() {
        return this.registeredBoats;
    }
    
}
