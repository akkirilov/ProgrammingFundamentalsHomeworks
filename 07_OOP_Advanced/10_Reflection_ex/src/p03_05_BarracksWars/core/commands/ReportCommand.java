package p03_05_BarracksWars.core.commands;

import p03_05_BarracksWars.annotations.Inject;
import p03_05_BarracksWars.contracts.Repository;
import p03_05_BarracksWars.contracts.UnitFactory;

public class ReportCommand extends Command {
	
	@Inject
	private Repository repository;

	public ReportCommand(String[] data) {
		super(data);
	}

	@Override
	public String execute() {
		String output = this.repository.getStatistics();
		return output;
	}

}
