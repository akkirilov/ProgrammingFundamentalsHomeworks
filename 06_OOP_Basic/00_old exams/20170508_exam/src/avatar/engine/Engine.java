package avatar.engine;

import java.util.List;

import avatar.controllers.AvatarController;
import avatar.io.ConsoleInputReader;
import avatar.utilities.InputParser;

public class Engine {
	
	private ConsoleInputReader consoleInputReader;
	private InputParser inputParser;
	private AvatarController avatarController;
	
	public Engine() {
		this.consoleInputReader = new ConsoleInputReader();
		this.inputParser = new InputParser();
		this.avatarController = new AvatarController();
	}

	public void run() {
		
		String type;
		String name;
		String nation;
		int power;
		int affinity;
		double secondaryParameter;
		
		List<String> args = this.inputParser.parseInput(consoleInputReader.readLine());
		while(true) {
			String command = args.get(0);
			if (command.equals("Quit")) {
				this.avatarController.quit();
				break;
			}
			switch (command) {
			case "Bender":
				type = args.get(1);
				name = args.get(2);
				power = Integer.parseInt(args.get(3));
				secondaryParameter = Double.parseDouble(args.get(4));
				this.avatarController.createBender(type, name, power, secondaryParameter);
				break;
			case "Monument":
				type = args.get(1);
				name = args.get(2);
				affinity = Integer.parseInt(args.get(3));
				this.avatarController.createMonument(type, name, affinity);
				break;
			case "War":
				nation = args.get(1);
				this.avatarController.war(nation);
				break;
			case "Status":
				nation = args.get(1);
				this.avatarController.status(nation);
				break;
			default:
				break;
			}
			
			args = this.inputParser.parseInput(consoleInputReader.readLine());
		}
		
	}
	
}
