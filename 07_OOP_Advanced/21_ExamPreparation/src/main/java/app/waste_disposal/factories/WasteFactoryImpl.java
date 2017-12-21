package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.contracts.WasteFactory;
import app.waste_disposal.models.wastes.*;
import app.waste_disposal.utils.Constants;

public class WasteFactoryImpl implements WasteFactory {

	@Override
	public Waste create(String type, String name, double volumePerKg, double weight, GarbageDisposalStrategy strategy) {
		switch (type) {
		case Constants.RECYCLABLE_STRATEGY_TYPE:
			return new RecyclableGarbage(name, volumePerKg, weight, strategy);
		case Constants.BURNABLE_STRATEGY_TYPE:
			return new BurnableGarbage(name, volumePerKg, weight, strategy);
		case Constants.STORABLE_STRATEGY_TYPE:
			return new StorableGarbage(name, volumePerKg, weight, strategy);
		default:
			return null;
		}
	}

}
