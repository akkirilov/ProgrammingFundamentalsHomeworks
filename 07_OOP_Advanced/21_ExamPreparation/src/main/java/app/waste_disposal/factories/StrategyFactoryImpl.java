package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyFactory;
import app.waste_disposal.models.strategies.*;
import app.waste_disposal.utils.Constants;

public class StrategyFactoryImpl implements StrategyFactory {

	@Override
	public GarbageDisposalStrategy create(String type) {
		switch (type) {
		case Constants.RECYCLABLE_STRATEGY_TYPE:
			return new RecyclableGarbageStrategy();
		case Constants.BURNABLE_STRATEGY_TYPE:
			return new BurnableGarbageStrategy();
		case Constants.STORABLE_STRATEGY_TYPE:
			return new StorableGarbageStrategy();
		default:
			return null;
		}
	}

}
