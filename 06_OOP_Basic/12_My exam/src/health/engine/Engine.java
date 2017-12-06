package health.engine;

import java.util.List;

import health.controllers.HealthManager;
import health.io.ConsoleInputReader;
import health.utilities.InputParser;

public class Engine {
	
	private HealthManager manager;
	private ConsoleInputReader consoleInputReader;
	private InputParser inputParser;

	public Engine() {
		this.consoleInputReader = new ConsoleInputReader();
		this.inputParser = new InputParser();
		this.manager = new HealthManager();
	}

	public void run() {
		
		String res = null;
		
		while(true) {
			String command = consoleInputReader.readLine();
			if (command.equals("BEER IS COMING")) {
				
				break;
			}
			List<String> args = this.inputParser.parseInput(command);
			switch (args.get(0)) {
			case "checkCondition":
				res = manager.checkCondition(args.get(1));
				if (res != null) {
					System.out.print(res);
				}
				break;
			case "createOrganism":
				res = manager.createOrganism(args.get(1));
				if (res != null) {
					System.out.println(res);
				}
				break;
			case "addCluster":
				res = manager.addCluster(args.get(1), args.get(2), Integer.parseInt(args.get(3)), Integer.parseInt(args.get(4)));
				if (res != null) {
					System.out.println(res);
				}
				break;
			case "addCell":
				res = manager.addCell(args.get(1), args.get(2), args.get(3), args.get(4), 
						Integer.parseInt(args.get(5)), Integer.parseInt(args.get(6)), 
						Integer.parseInt(args.get(7)), Integer.parseInt(args.get(8)));
				if (res != null) {
					System.out.println(res);
				}
				break;
			case "activateCluster":
				res = manager.activateCluster(args.get(1));
				if (res != null) {
					System.out.println(res);
				}
				break;
			default:
				break;
			}
			
		}
		
	}
	
}
