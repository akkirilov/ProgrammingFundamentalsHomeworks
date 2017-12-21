package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;

@Burnable
public class BurnableGarbage extends AbstractGarbage {

	public BurnableGarbage(String name, double volumePerKg, double weight, GarbageDisposalStrategy strategy) {
		super(name, volumePerKg, weight);
	}

}
