package cresla.entities.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends AbstractReactor {
	
	private int heatReductionIndex;

	public HeatReactor(int id, int heatReductionIndex, Container container) {
		super(id, container);
		this.heatReductionIndex = heatReductionIndex;
	}

	@Override
	public long getTotalEnergyOutput() {
		if (super.getContainer().getTotalEnergyOutput() > this.getTotalHeatAbsorbing()) {
			return 0;
		}
		return super.getContainer().getTotalEnergyOutput();
		
	}

	@Override
	public long getTotalHeatAbsorbing() {
		return super.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
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
