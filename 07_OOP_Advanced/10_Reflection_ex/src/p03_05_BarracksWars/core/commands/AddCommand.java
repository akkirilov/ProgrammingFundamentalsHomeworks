package p03_05_BarracksWars.core.commands;

import p03_05_BarracksWars.annotations.Inject;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.Unit;
import p03_05_BarracksWars.contracts.UnitFactory;

public class AddCommand extends Command {
	
	@Inject
	private Repository repository;
	@Inject
	private UnitFactory unitFactory;

	public AddCommand(String[] data) {
		super(data);
	}

	@Override
	public String execute() {
		String unitType = super.getData()[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}

}
