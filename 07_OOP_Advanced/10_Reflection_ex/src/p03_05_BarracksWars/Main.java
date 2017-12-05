package p03_05_BarracksWars;

import p03_05_BarracksWars.contracts.CommandInterpreter;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.Runnable;
import p03_05_BarracksWars.contracts.UnitFactory;
import p03_05_BarracksWars.core.Engine;
import p03_05_BarracksWars.core.factories.UnitFactoryImpl;
import p03_05_BarracksWars.core.interpreters.CommandInterpreterImpl;
import p03_05_BarracksWars.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
		Runnable engine = new Engine(repository, unitFactory, commandInterpreter);
		engine.run();
	}
}
