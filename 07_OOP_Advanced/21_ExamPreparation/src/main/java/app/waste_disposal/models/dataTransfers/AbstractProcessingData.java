package app.waste_disposal.models.dataTransfers;

import app.waste_disposal.contracts.ProcessingData;

public abstract class AbstractProcessingData implements ProcessingData {
	private double energyBalance;
	private double capitalBalance;
	

	protected AbstractProcessingData(double energyBalance, double capitalBalance) {
		this.energyBalance = energyBalance;
		this.capitalBalance = capitalBalance;
	}

	@Override
	public double getEnergyBalance() {
		return this.energyBalance;
	}

	@Override
	public double getCapitalBalance() {
		return this.capitalBalance;
	}
	
}
