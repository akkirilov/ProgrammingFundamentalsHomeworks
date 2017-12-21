package app.waste_disposal.core;

import java.util.List;

import app.waste_disposal.contracts.*;
import app.waste_disposal.utils.*;

public class WasteManager implements Manager {

	private List<ProcessingData> dataList;
	private StrategyFactory strategyFactory;
	private WasteFactory wasteFactory;
	private GarbageProcessor garbageProcessor;
	private String restrictedGarbageType;
	private double energyMinCapacity;
	private double capitalMinCapacity;

	public WasteManager(List<ProcessingData> dataList, StrategyFactory strategyFactory, 
			WasteFactory wasteFactory, GarbageProcessor garbageProcessor) {
		this.dataList = dataList;
		this.strategyFactory = strategyFactory;
		this.wasteFactory = wasteFactory;
		this.garbageProcessor = garbageProcessor;
	}

	@Override
	public String processGarbage(String name, double weight, double volumePerKg, String type) {
		if (this.isRestricted(type)) {
			return Constants.PROCESSING_DENIED_MSG;
		}
		GarbageDisposalStrategy strategy = strategyFactory.create(type);
		Waste garbage = wasteFactory.create(type, name, volumePerKg, weight, strategy);
		ProcessingData data = this.garbageProcessor.processWaste(garbage);
		dataList.add(data);
		return String.format(Constants.WASTE_FORMAT, weight, name);
	}

	private boolean isRestricted(String type) {
		double energyBalance = this.getEnergyBalance();
		double capitalBalance = this.getCapitalBalance();
		if (type.equals(restrictedGarbageType)) {
			if (energyBalance < this.energyMinCapacity || capitalBalance < this.capitalMinCapacity) {
				return true;
			}
		}
		return false;
	}

	private double getEnergyBalance() {
		double energyBalance = 0.0;
		for (ProcessingData d : this.dataList) {
			energyBalance += d.getEnergyBalance();
		}
		return energyBalance;
	}

	private double getCapitalBalance() {
		double capitalBalance = 0.0;
		for (ProcessingData d : this.dataList) {
			capitalBalance += d.getCapitalBalance();
		}
		return capitalBalance;
	}

	@Override
	public String changeManagementRequirement(double energyBalance, double capitalBalance, String garbageType) {
		this.energyMinCapacity = energyBalance;
		this.capitalMinCapacity = capitalBalance;
		this.restrictedGarbageType = garbageType;
		return Constants.CHANGE_MANAGEMENT_REQUIREMENTS_MSG;
	}
	
	@Override
	public String status() {
		double energyBalance = this.getEnergyBalance();
		double capitalBalance = this.getCapitalBalance();
		return String.format(Constants.STATUS_FORMAT, energyBalance, capitalBalance);
	}

}
