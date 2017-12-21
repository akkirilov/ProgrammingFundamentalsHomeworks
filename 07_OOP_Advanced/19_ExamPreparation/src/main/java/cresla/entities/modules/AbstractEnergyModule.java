package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {

	private int energyOutput;
	
	protected AbstractEnergyModule(int id, int energyOutput) {
		super(id);
		this.energyOutput = energyOutput;
	}

	@Override
	public int getEnergyOutput() {
		return this.energyOutput;
	}

	@Override
	public String toString() {
		return String.format("%s%n"
				+ "Energy Output: %d", 
				super.toString(),
				this.energyOutput);
	}

}
