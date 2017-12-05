package p03_05_BarracksWars.core.commands;

import p03_05_BarracksWars.contracts.Executable;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.UnitFactory;

public abstract class Command implements Executable {
	
	private String[] data;
	private Repository repository;
	private UnitFactory unitFactory;
	
	protected Command(String[] data) {
		super();
		this.data = data;
	}

	protected String[] getData() {
		return data;
	}

}
