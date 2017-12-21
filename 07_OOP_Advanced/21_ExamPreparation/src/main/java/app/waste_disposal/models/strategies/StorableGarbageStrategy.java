package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.dataTransfers.BalanceData;

public class StorableGarbageStrategy extends AbstractStrategy {

	@Override
	public ProcessingData processGarbage(Waste garbage) {
		double energyBalance = ((garbage.getVolumePerKg() * garbage.getWeight()) * 0.13) * -1;;
		double capitalBalance = ((garbage.getVolumePerKg() * garbage.getWeight()) * 0.65) * -1;
		return new BalanceData(energyBalance, capitalBalance);
	}

}
