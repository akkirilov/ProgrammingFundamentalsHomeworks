package paw.engine;

import java.util.List;

import paw.controllers.AnimalCenterManager;
import paw.io.ConsoleInputReader;
import paw.utilities.Constants;
import paw.utilities.InputParser;

public class Engine {
	
	private AnimalCenterManager manager;
	private ConsoleInputReader consoleInputReader;
	private InputParser inputParser;

	public Engine() {
		this.manager = new AnimalCenterManager();
		this.consoleInputReader = new ConsoleInputReader();
		this.inputParser = new InputParser();
	}

	public void run() {
		
		String command;
		
		List<String> args = this.inputParser.parseInput(consoleInputReader.readLine());
		while(true) {
			command = args.get(0);
			if (command.equals(Constants.TERMINATING_COMMAND)) {
				manager.printStatistics();
				break;
			}
			switch (command) {
			case Constants.ADOPTING_CENTER_COMMAND:
				manager.registerAdoptionCenter(args.get(1));
				break;
			case Constants.CLEANSING_CENTER_COMMAND:
				manager.registerCleansingCenter(args.get(1));
				break;
			case Constants.DOG_COMMAND:
				manager.registerDog(args.get(1), Integer.parseInt(args.get(2)), 
						Integer.parseInt(args.get(3)), args.get(4));
				break;
			case Constants.CAT_COMMAND:
				manager.registerCat(args.get(1), Integer.parseInt(args.get(2)), 
						Integer.parseInt(args.get(3)), args.get(4));
				break;
			case Constants.ADOPT_COMMAND:
				manager.adopt(args.get(1));
				break;
			case Constants.SEND_FOR_CLEANSING_COMMAND:
				manager.sendForCleansing(args.get(1), args.get(2));
				break;
			case Constants.CLEANSING_COMMAND:
				manager.cleanse(args.get(1));
				break;
			case Constants.CASTRATION_CENTER_COMMAND:
				manager.registerCastrationCenter(args.get(1));
				break;
			case Constants.SEND_FOR_CASTRATION_COMMAND:
				manager.sendForCastration(args.get(1), args.get(2));
				break;
			case Constants.CASTRATE_COMMAND:
				manager.castrate(args.get(1));
				break;
			case Constants.CASTRATION_STATISTICS:
				manager.printCastrateStatistics();
				break;
			default:
				break;
			}
			
			args = this.inputParser.parseInput(consoleInputReader.readLine());
		}
		
	}
	
}
