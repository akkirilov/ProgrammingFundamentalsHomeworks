package app.waste_disposal.models.wastes;

import app.waste_disposal.contracts.Waste;

public abstract class AbstractGarbage implements Waste {

	private String name;
	private double volumePerKg;
	private double weight;

	protected AbstractGarbage(String name, double volumePerKg, double weight) {
		this.name = name;
		this.volumePerKg = volumePerKg;
		this.weight = weight;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getVolumePerKg() {
		return this.volumePerKg;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

}
