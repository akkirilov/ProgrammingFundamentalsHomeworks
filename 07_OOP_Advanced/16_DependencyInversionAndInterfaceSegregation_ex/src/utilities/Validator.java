package utilities;

import contracts.IRace;
import exeptions.NoSetRaceException;
import exeptions.RaceAlreadyExistsException;

public class Validator {
	
    public static void validatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void validateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectModelLenghtMessage, minModelLength));
        }
    }
    
    public static void validateRaceIsSet(IRace race) throws NoSetRaceException {
        if (race == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    public static void validateRaceIsEmpty(IRace race) throws RaceAlreadyExistsException {
        if (race != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
    
}
