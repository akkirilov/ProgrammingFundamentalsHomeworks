package cresla.core;

import java.util.List;
import java.util.Map;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Container;
import cresla.interfaces.Manager;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;
import cresla.utils.Constants;

public class ReactorManager implements Manager {

	private int id;
	private Map<Integer, Reactor> reactors;
	private Map<Integer, Module> modules;
	
	public ReactorManager(Map<Integer, Reactor> reactors, Map<Integer, Module> modules) {
		this.reactors = reactors;
		this.modules = modules;
		this.id = 1;
	}

	@Override
	public String reactorCommand(List<String> arguments) {
		int currentId = id++;
		int param = Integer.parseInt(arguments.get(2));
		String reactorType = arguments.get(1);
		Container container = new ModuleContainer(Integer.parseInt(arguments.get(3)));
		Reactor reactor = null;
		if (reactorType.equals(Constants.CREATE_CRYO_REACTOR_TYPE)) {
			reactor = new CryoReactor(currentId, param, container);
		} else if (reactorType.equals(Constants.CREATE_HEAT_REACTOR_TYPE)) {
			reactor = new HeatReactor(currentId, param, container);
		}
		reactors.put(currentId, reactor);
		return String.format("Created %s Reactor - %s", reactorType, currentId);
	}

	@Override
	public String moduleCommand(List<String> arguments) {
		int currentId = id++;
		int reactorId = Integer.parseInt(arguments.get(1));
		int param = Integer.parseInt(arguments.get(3));
		String moduleType = arguments.get(2);
		if (moduleType.equals(Constants.CREATE_COOLDOWNSYSTEM_MODULE_TYPE)) {
			modules.put(currentId, new CooldownSystem(currentId, param));
			reactors.get(reactorId).addAbsorbingModule(new CooldownSystem(currentId, param));
		} else if (moduleType.equals(Constants.CREATE_HEATPROCESSOR_MODULE_TYPE)) {
			reactors.get(reactorId).addAbsorbingModule(new HeatProcessor(currentId, param));
			modules.put(currentId, new HeatProcessor(currentId, param));
		} else if (moduleType.equals(Constants.CREATE_CRYOGENROD_MODULE_TYPE)) {
			modules.put(currentId, new CryogenRod(currentId, param));
			reactors.get(reactorId).addEnergyModule(new CryogenRod(currentId, param));
		}
		return String.format("Added %s - %d to Reactor - %d", moduleType, currentId, reactorId);
	}

	@Override
	public String reportCommand(List<String> arguments) {
		int itemId = Integer.parseInt(arguments.get(1));
		if (reactors.containsKey(itemId)) {
			return reactors.get(itemId).toString();
		} else if (modules.containsKey(itemId)) {
			return modules.get(itemId).toString();
		}
		return null;
	}

	@Override
	public String exitCommand(List<String> arguments) {
		int cryoReactorsCount = 0;
		int heatReactorsCount = 0;
		int energyModulesCount = 0;
		int absorbingModulesCount = 0;
		long totalEnergyOutput = 0;
		long totalHeatAbsorbing = 0;

		for (Map.Entry<Integer, Reactor> r : reactors.entrySet()) {
			if (r.getValue().toString().startsWith("Cryo")) {
				cryoReactorsCount++;
			} else {
				heatReactorsCount++;
			}
			totalEnergyOutput += r.getValue().getTotalEnergyOutput();
			totalHeatAbsorbing += r.getValue().getTotalHeatAbsorbing();
		}

		for (Map.Entry<Integer, Module> m : modules.entrySet()) {
			if (m.getValue().toString().startsWith("Cryo")) {
				energyModulesCount++;
			} else {
				absorbingModulesCount++;
			}
		}
		
		return String.format("Cryo Reactors: %d%n"
				+ "Heat Reactors: %d%n"
				+ "Energy Modules: %d%n"
				+ "Absorbing Modules: %d%n"
				+ "Total Energy Output: %d%n"
				+ "Total Heat Absorbing: %d", 
				cryoReactorsCount, 
				heatReactorsCount,
				energyModulesCount,
				absorbingModulesCount,
				totalEnergyOutput,
				totalHeatAbsorbing);
	}

}
