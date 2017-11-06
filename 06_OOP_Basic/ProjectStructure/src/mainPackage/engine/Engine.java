package mainPackage.engine;

import java.util.List;

import mainPackage.io.ConsoleInputReader;
import mainPackage.utilities.InputParser;

public class Engine {
	
	private ConsoleInputReader consoleInputReader;
	private InputParser inputParser;

	public Engine() {
		this.consoleInputReader = new ConsoleInputReader();
		this.inputParser = new InputParser();
		
	}

	public void run() {
		
		String command;
		
		List<String> args = this.inputParser.parseInput(consoleInputReader.readLine());
		while(true) {
			command = args.get(0);
			if (command.equals("Quit")) {
				
				break;
			}
			switch (command) {
			case "a":
				break;
			case "b":
				break;
			case "c":
				break;
			case "d":
				break;
			default:
				break;
			}
			
			args = this.inputParser.parseInput(consoleInputReader.readLine());
		}
		
	}
	
}
