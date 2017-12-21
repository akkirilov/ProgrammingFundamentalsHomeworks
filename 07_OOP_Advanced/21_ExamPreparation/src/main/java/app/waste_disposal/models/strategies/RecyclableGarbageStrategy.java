package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.dataTransfers.BalanceData;

public class RecyclableGarbageStrategy extends AbstractStrategy {

	@Override
	public ProcessingData processGarbage(Waste garbage) {
		double energyBalance = ((garbage.getVolumePerKg() * garbage.getWeight()) * 0.5) * -1;;
		double capitalBalance = 400 * garbage.getWeight();
		return new BalanceData(energyBalance, capitalBalance);
	}

}
