package Core;

import contracts.IBoatSimulatorController;
import contracts.ICommandHandler;
import controllers.BoatSimulatorController;
import exeptions.*;

import java.util.List;

public class CommandHandler implements ICommandHandler {
	public IBoatSimulatorController controller;

	public CommandHandler(IBoatSimulatorController controller) {
		this.setContrller(controller);
	}

	public CommandHandler() {
		this.setContrller(new BoatSimulatorController());
	}

	private void setContrller(IBoatSimulatorController controller) {
		this.controller = controller;
	}

	@Override
	public String executeCommand(String name, List<String> parameters)
			throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, 
			NoSetRaceException, InsufficientContestantsException, IncorectBoatTypeException {
		switch (name) {
		case "CreateBoatEngine":
			return this.controller.createBoatEngine(parameters.get(0), Integer.parseInt(parameters.get(1)),
					Integer.parseInt(parameters.get(2)), parameters.get(3));
		case "CreateRowBoat":
			return this.controller.createRowBoat(parameters.get(0), Integer.parseInt(parameters.get(1)),
					Integer.parseInt(parameters.get(2)));
		case "CreateSailBoat":
			return this.controller.createSailBoat(parameters.get(0), Integer.parseInt(parameters.get(1)),
					Integer.parseInt(parameters.get(2)));
		case "CreatePowerBoat":
			return this.controller.createPowerBoat(parameters.get(0), Integer.parseInt(parameters.get(1)),
					parameters.get(2), parameters.get(3));
		case "CreateYacht":
			return this.controller.createYacht(parameters.get(0), Integer.parseInt(parameters.get(1)),
					parameters.get(2), Integer.parseInt(parameters.get(3)));
		case "OpenRace":
			return this.controller.openRace(Integer.parseInt(parameters.get(0)),
					Integer.parseInt(parameters.get(1)), Integer.parseInt(parameters.get(2)),
					Boolean.parseBoolean(parameters.get(3)));
		case "SignUpBoat":
			return this.controller.signUpBoat(parameters.get(0));
		case "StartRace":
			return this.controller.startRace();
		case "GetStatistic":
			return this.controller.getStatistic();
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
