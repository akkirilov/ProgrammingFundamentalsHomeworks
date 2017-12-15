package contracts;

import exeptions.*;

import java.util.List;

public interface ICommandHandler {
    
	String executeCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException, IncorectBoatTypeException;

}
