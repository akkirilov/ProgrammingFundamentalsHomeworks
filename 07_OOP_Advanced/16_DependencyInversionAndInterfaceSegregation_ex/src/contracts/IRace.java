package contracts;

import exeptions.DuplicateModelException;
import exeptions.IncorectBoatTypeException;

import java.util.List;

public interface IRace {
    int getDistance();

    int getWindSpeed ();

    int getOceanCurrentSpeed();

    void addParticipant(IBoat boat) throws DuplicateModelException, IncorectBoatTypeException;

    List<IBoat> getParticipants();
    
}