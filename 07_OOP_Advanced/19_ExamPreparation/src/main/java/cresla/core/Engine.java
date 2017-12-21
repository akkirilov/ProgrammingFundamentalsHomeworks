package cresla.core;

import java.util.List;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.utils.CommandParser;
import cresla.utils.Constants;

public class Engine {
	
	private Manager manager;
	private InputReader reader;
	private OutputWriter writer;
	private CommandParser commandParser;
	
	public Engine(Manager manager, InputReader reader, OutputWriter writer) {
		this.manager = manager;
		this.reader = reader;
		this.writer = writer;
		this.commandParser = new CommandParser();
	}

	public void run() {
		
		while (true) {
			String input = this.reader.readLine();
			List<String> arguments = this.commandParser.parseBySpace(input);
			if (input.equals(Constants.TERMINATION_COMMAND)) {
				this.writer.writeLine(manager.exitCommand(arguments));
				break;
			}
			switch (arguments.get(0)) {
			case Constants.CREATE_REACTOR_COMMAND:
				this.writer.writeLine(manager.reactorCommand(arguments));
				break;
			case Constants.CREATE_MODULE_COMMAND:
				this.writer.writeLine(manager.moduleCommand(arguments));
				break;
			case Constants.REPORT_COMMAND:
				this.writer.writeLine(manager.reportCommand(arguments));
				break;
			default:
				break;
			}
		}
		
	}
	
}
