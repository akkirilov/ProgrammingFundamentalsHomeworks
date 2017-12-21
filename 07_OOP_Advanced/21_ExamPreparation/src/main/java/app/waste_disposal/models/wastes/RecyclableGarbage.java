package app.waste_disposal.models.wastes;

import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;

@Recyclable
public class RecyclableGarbage extends AbstractGarbage {
	
	public RecyclableGarbage(String name, double volumePerKg, double weight, GarbageDisposalStrategy strategy) {
		super(name, volumePerKg, weight);
	}

}
