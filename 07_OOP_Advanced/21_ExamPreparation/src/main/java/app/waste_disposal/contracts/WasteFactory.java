package app.waste_disposal.contracts;

public interface WasteFactory {

	Waste create(String type, String name, double volumePerKg, double weight, GarbageDisposalStrategy strategy);
	
}
