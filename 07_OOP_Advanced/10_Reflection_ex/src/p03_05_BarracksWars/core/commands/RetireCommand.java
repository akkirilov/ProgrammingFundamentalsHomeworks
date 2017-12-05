package p03_05_BarracksWars.core.commands;

import p03_05_BarracksWars.annotations.Inject;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RetireCommand extends Command {
	
	@Inject
	private Repository repository;
	
	public RetireCommand(String[] data) {
		super(data);
	}

	@Override
	public String execute() {
		String unitType = super.getData()[1];
		try {
			this.repository.removeUnit(unitType);
		} catch (NotImplementedException e) {
			return "No such units in repository.";
		}
		String output = unitType + " retired!";
		return output;
	}

}
