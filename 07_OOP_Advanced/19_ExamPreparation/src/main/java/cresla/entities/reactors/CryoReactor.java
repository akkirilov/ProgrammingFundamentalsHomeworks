package cresla.entities.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends AbstractReactor {
	
	private int cryoProductionIndex;

	public CryoReactor(int id, int cryoProductionIndex, Container container) {
		super(id, container);
		this.cryoProductionIndex = cryoProductionIndex;
	}

	@Override
	public long getTotalEnergyOutput() {
		if (super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex > this.getTotalHeatAbsorbing()) {
			return 0;
		}
		return super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
	}

	@Override
	public long getTotalHeatAbsorbing() {
		return super.getContainer().getTotalHeatAbsorbing();
	}

	@Override
	public String toString() {
		return String.format("%s%n"
				+ "Energy Output: %d%n"
				+ "Heat Absorbing: %d%n"
				+ "Modules: %d", 
				super.toString(),
				this.getTotalEnergyOutput(),
				this.getTotalHeatAbsorbing(),
				super.getModuleCount());
	}
	
}
