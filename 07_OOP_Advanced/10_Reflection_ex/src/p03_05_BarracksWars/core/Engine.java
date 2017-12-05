package p03_05_BarracksWars.core;

import p03_05_BarracksWars.contracts.CommandInterpreter;
import p03_05_BarracksWars.contracts.Executable;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.Runnable;
import p03_05_BarracksWars.contracts.Unit;
import p03_05_BarracksWars.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
	
	private static final String COMMAND_PACKAGE_NAME =
			"p03_05_BarracksWars.core.commands.";

	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter commandInterpreter;

	public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter commandInterpreter) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpredCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpredCommand(String[] data, String commandName) {
		Executable command = this.commandInterpreter.interpretCommand(data, commandName);
		if (command == null) {
			throw new RuntimeException("Invalid command!");
		}
		String result = command.execute();
		return result;
	}

}
