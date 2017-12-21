package app.waste_disposal.core;

import app.waste_disposal.contracts.*;
import app.waste_disposal.utils.Constants;

public class WasteEngine implements Engine {

	private InputReader reader;
	private OutputWriter writer;
	private Manager manager;

	public WasteEngine(InputReader reader, OutputWriter writer, Manager manager) {
		this.reader = reader;
		this.writer = writer;
		this.manager = manager;
	}

	@Override
	public void run() {
		String[] tokens;
		String output = "";
		while (true) {
			String line = this.reader.readLine();
			if (line.equals(Constants.TERMINATION_COMMAND)) {
				break;
			}
			String[] command = line.split("\\s+");
			switch (command[0]) {
			case Constants.PROCESS_GARBAGE_COMMAND:
				tokens = command[1].split("\\|");
				output = this.manager.processGarbage(tokens[0], Double.parseDouble(tokens[1]),
						Double.parseDouble(tokens[2]), tokens[3]);
				this.writer.writeLine(output);
				break;
			case Constants.STATUS_COMMAND:
				output = this.manager.status();
				this.writer.writeLine(output);
				break;
			case Constants.CHANGE_MANAGEMENT_REQUIREMENTS_COMMAND:
				tokens = command[1].split("\\|");
				output = this.manager.changeManagementRequirement(Double.parseDouble(tokens[0]),
						Double.parseDouble(tokens[1]), tokens[2]);
				this.writer.writeLine(output);
				break;
			default:
				break;
			}
		}

	}

}
