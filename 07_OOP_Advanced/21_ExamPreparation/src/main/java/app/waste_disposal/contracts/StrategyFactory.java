package app.waste_disposal.contracts;

public interface StrategyFactory {

	GarbageDisposalStrategy create(String type);
	
}
