package p03_05_BarracksWars.core.interpreters;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import p03_05_BarracksWars.annotations.Inject;
import p03_05_BarracksWars.contracts.CommandInterpreter;
import p03_05_BarracksWars.contracts.Executable;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.UnitFactory;
import p03_05_BarracksWars.core.commands.AddCommand;
import p03_05_BarracksWars.core.commands.Command;

public class CommandInterpreterImpl implements CommandInterpreter {

	private static final String COMMAND_PACKAGE_NAME =
			"p03_05_BarracksWars.core.commands.";
	
	private Repository repository;
	private UnitFactory unitFactory;
	
	public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
		super();
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public Executable interpretCommand(String[] data, String commandName) {
		String commandPath = COMMAND_PACKAGE_NAME + commandName.toUpperCase().charAt(0) + commandName.substring(1) + "Command";
		try {
			Class<?> commandClass = Class.forName(commandPath);
			Field[] fields = commandClass.getDeclaredFields();
			Constructor<Command> commandConstructor = (Constructor<Command>) commandClass.getConstructor(String[].class);
			commandConstructor.setAccessible(true);
			Command command = (Command) commandConstructor.newInstance((Object)data);
			for (Field field : fields) {
				if (field.isAnnotationPresent(Inject.class)) {
					field.setAccessible(true);
					if (field.getType().equals(Repository.class)) {
						field.set(command, this.repository);
					} else if (field.getType().equals(UnitFactory.class)) {
						field.set(command, this.unitFactory);
					}
				}
			}
			return command;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
