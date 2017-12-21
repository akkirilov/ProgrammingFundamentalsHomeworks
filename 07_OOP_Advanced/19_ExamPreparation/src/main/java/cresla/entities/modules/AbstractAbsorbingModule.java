package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends AbstractModule implements AbsorbingModule {

	private int heatAbsorbing;

	protected AbstractAbsorbingModule(int id, int heatAbsorbing) {
		super(id);
		this.heatAbsorbing = heatAbsorbing;
	}

	@Override
	public int getHeatAbsorbing() {
		return this.heatAbsorbing;
	}

	@Override
	public String toString() {
		return String.format("%s%n"
				+ "Heat Absorbing: %d", 
				super.toString(),
				this.heatAbsorbing);
	}
	
}
