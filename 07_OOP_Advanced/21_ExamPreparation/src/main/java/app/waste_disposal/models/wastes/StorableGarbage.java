package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;

@Storable
public class StorableGarbage extends AbstractGarbage {
	
	public StorableGarbage(String name, double volumePerKg, double weight, GarbageDisposalStrategy strategy) {
		super(name, volumePerKg, weight);
	}

}
