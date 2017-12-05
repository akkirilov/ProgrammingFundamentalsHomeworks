package p03_05_BarracksWars.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
	
}
