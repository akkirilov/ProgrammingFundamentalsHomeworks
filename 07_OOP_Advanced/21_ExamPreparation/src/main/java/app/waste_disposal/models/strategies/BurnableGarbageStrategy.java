package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.dataTransfers.BalanceData;

public class BurnableGarbageStrategy extends AbstractStrategy {

	@Override
	public ProcessingData processGarbage(Waste garbage) {
		double energyBalance = (garbage.getVolumePerKg() * garbage.getWeight() * (1 - 0.2));
		double capitalBalance = 0;
		return new BalanceData(energyBalance, capitalBalance);
	}

}
