package cresla.entities.reactors;

import java.lang.reflect.Field;
import java.util.LinkedList;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

public abstract class AbstractReactor implements Reactor {
	
	private int id;
	private Container moduleContainer;
		
	protected AbstractReactor(int id, Container container) {
		this.id = id;
		this.moduleContainer = container;
	}
	
	protected Container getContainer() {
		return this.moduleContainer;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int getModuleCount() {
		try {
			Field field = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
			field.setAccessible(true);
			return ((LinkedList<Module>) field.get(this.moduleContainer)).size();
		} catch (NoSuchFieldException | SecurityException 
				| IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public void addEnergyModule(EnergyModule energyModule) {
		this.moduleContainer.addEnergyModule(energyModule);
	}

	@Override
	public void addAbsorbingModule(AbsorbingModule absorbingModule) {
		this.moduleContainer.addAbsorbingModule(absorbingModule);
	}
	
	@Override
	public abstract long getTotalEnergyOutput();

	@Override
	public abstract long getTotalHeatAbsorbing();

	@Override
	public String toString() {
		return String.format("%s - %d", this.getClass().getSimpleName(), this.id);
	}
	
}
