package controllers;

import contracts.IBoat;
import contracts.IBoatDatabase;
import contracts.IBoatSimulatorController;
import contracts.IEngine;
import contracts.IRace;
import database.BoatSimulatorDatabase;
import exeptions.*;
import factories.EngineFactory;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.races.Race;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utilities.Constants;
import utilities.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorController implements IBoatSimulatorController {

	private IBoatDatabase database;
	private IRace currentRace;

	public BoatSimulatorController(IBoatDatabase database, IRace currentRace) {
		this.setDatabase(database);
		this.setCurrentRace(currentRace);
	}

	public BoatSimulatorController() {
		this.setDatabase(new BoatSimulatorDatabase());
		this.setCurrentRace(null);
	}

	private void setCurrentRace(IRace currentRace) {
		this.currentRace = currentRace;
	}

	private void setDatabase(IBoatDatabase database) {
		this.database = database;
	}

	@Override
	public String createBoatEngine(String model, int horsepower, int displacement, String engineType)
			throws DuplicateModelException {
		IEngine engine = EngineFactory.create(model, horsepower, displacement, engineType);
		if (engine == null) {
			throw new NotImplementedException();
		}
		this.database.getEngines().add(engine);
		return String.format("Engine model %s with %s HP and displacement %s cm3 created successfully.", model,
				horsepower, displacement);
	}

	@Override
	public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
		IBoat boat = new RowBoat(model, weight, oars);
		this.database.getBoats().add(boat);
		return String.format("Row boat with model %s registered successfully.", model);
	}

	@Override
	public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
		IBoat boat = new SailBoat(model, weight, sailEfficiency);
		this.database.getBoats().add(boat);
		return String.format("Sail boat with model %s registered successfully.", model);
	}

	@Override
	public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
			throws NonExistantModelException, DuplicateModelException {
		IEngine firstEngine = this.database.getEngines().getItem(firstEngineModel);
		IEngine secondEngine = this.database.getEngines().getItem(secondEngineModel);
		PowerBoat boat = new PowerBoat(model, weight, Arrays.asList(firstEngine, secondEngine));
		this.database.getBoats().add(boat);
		return String.format("Power boat with model %s registered successfully.", model);
	}

	@Override
	public String createYacht(String model, int weight, String engineModel, int cargoWeight)
			throws NonExistantModelException, DuplicateModelException {
		IEngine engine = this.database.getEngines().getItem(engineModel);
		Yacht boat = new Yacht(model, weight, cargoWeight, engine);
		this.database.getBoats().add(boat);
		return String.format("Yacht with model %s registered successfully.", model);
	}

	@Override
	public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats)
			throws RaceAlreadyExistsException {
		IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
		Validator.validateRaceIsEmpty(this.currentRace);
		this.currentRace = race;
		return String.format(
				"A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
				distance, windSpeed, oceanCurrentSpeed);
	}

	@Override
	public String signUpBoat(String model)
			throws NonExistantModelException, DuplicateModelException, NoSetRaceException, IncorectBoatTypeException {
		IBoat boat = this.database.getBoats().getItem(model);
		Validator.validateRaceIsSet(this.currentRace);
		this.currentRace.addParticipant(boat);
		return String.format("Boat with model %s has signed up for the current Race.", model);
	}

	@Override
    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
    	Validator.validateRaceIsSet(this.currentRace);
        List<IBoat> participants = this.currentRace.getParticipants()
        			.stream()
        			.sorted((a, b) -> {
        				int res = Double.compare(this.currentRace.getDistance() / a.getRaceSpeed(this.currentRace), 
        						this.currentRace.getDistance() / b.getRaceSpeed(this.currentRace));
//        				if (res == 0) {
//							for (IBoat s : this.currentRace.getParticipants()) {
//								if (this.currentRace.getDistance() / a.getRaceSpeed(this.currentRace) == s.getRaceSpeed(this.currentRace)) {
//									if (a.getModel() == s.getModel()) {
//										res = 1;
//									} else {
//										res = -1;
//									}
//								}
//							}
//						}
        				return res;
        			})
        			.collect(Collectors.toList());
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        int counter = 0;
        StringBuffer sb = new StringBuffer();
        List<String> places = new ArrayList<>(Arrays.asList("First place", "Second place", "Third place"));
        for (int i = 0; i < participants.size(); i++) {
        	if (counter == 3) {
				break;
			}
        	double time = this.currentRace.getDistance() / participants.get(i).getRaceSpeed(this.currentRace);
        	if (time >= 0.0) {
        		IBoat boat = participants.remove(i);
        		i--;
        		sb.append(String.format("%s: %s Model: %s Time: %.2f sec%n",
        			places.remove(0),
        			boat.getClass().getSimpleName().toString(),
        			boat.getModel(),
           			time));
        		counter++;
			}
		}
        for (IBoat boat : participants) {
        	if (counter == 3) {
				break;
			}
        	sb.append(String.format("%s: %s Model: %s Time: Did not finish!%n",
        			places.remove(0),
        			boat.getClass().getSimpleName().toString(),
        			boat.getModel()));
        	counter++;
		}

        this.currentRace = null;
        
        return sb.substring(0, sb.length() - 2).toString();
    }

	@Override
	public String getStatistic() {
		StringBuilder sb = new StringBuilder();
		List<IBoat> participants = (List<IBoat>) this.currentRace.getParticipants()
    			.stream()
    			.sorted((a, b) -> a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName()))
    			.collect(Collectors.toList());
		Map<String, Integer> statistics = new LinkedHashMap<>();
		double divider = participants.size();
		for (IBoat boat : participants) {
			if (statistics.containsKey(boat.getClass().getSimpleName())) {
				statistics.put(boat.getClass().getSimpleName(), statistics.get(boat.getClass().getSimpleName()) + 1);
			} else {
				statistics.put(boat.getClass().getSimpleName(), 1);
			}
		}
		for (Map.Entry<String, Integer> e : statistics.entrySet()) {
			sb.append(String.format("%s -> %.2f%%%n", e.getKey(), (e.getValue() / divider) * 100));
		}
		return sb.substring(0, sb.length() - 2).toString();
	}

}
