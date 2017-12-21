package creslaTests;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

public class ContainerTests {
	
	private AbsorbingModule absorbingModule1;
	private AbsorbingModule absorbingModule2;
	private EnergyModule energyModule1;
	private EnergyModule energyModule2;
	private Container container;
	
	@Before
	public void initialization() {
		this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
		this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);;
		this.energyModule1 = Mockito.mock(EnergyModule.class);
		this.energyModule2 = Mockito.mock(EnergyModule.class);
		this.container = new ModuleContainer(3);
		
		Mockito.when(this.absorbingModule1.getHeatAbsorbing()).thenReturn(2000000000);
		Mockito.when(this.absorbingModule2.getHeatAbsorbing()).thenReturn(2000000000);
		Mockito.when(this.energyModule1.getEnergyOutput()).thenReturn(2000000000);
		Mockito.when(this.energyModule2.getEnergyOutput()).thenReturn(2000000000);
		
		Mockito.when(this.absorbingModule1.getId()).thenReturn(1);
		Mockito.when(this.absorbingModule2.getId()).thenReturn(2);
		Mockito.when(this.energyModule1.getId()).thenReturn(3);
		Mockito.when(this.energyModule2.getId()).thenReturn(4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void absorbingModuleExeption() {
		this.container.addAbsorbingModule(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void tnergyModuleExeption() {
		this.container.addEnergyModule(null);
	}
	
	@Test
	public void emptyContainer() {
		Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
		Assert.assertEquals(0, this.container.getTotalEnergyOutput());
	}
	
	@Test
	public void totalHeatAbsorbing() {
		this.container.addAbsorbingModule(this.absorbingModule1);
		this.container.addAbsorbingModule(this.absorbingModule2);
		
		Assert.assertEquals(4000000000L, this.container.getTotalHeatAbsorbing());
	}
	
	@Test
	public void totalEnergyOutput() {
		this.container.addEnergyModule(this.energyModule1);
		this.container.addEnergyModule(this.energyModule2);
		
		Assert.assertEquals(4000000000L, this.container.getTotalEnergyOutput());
	}
	
	@Test
	public void AddAndRemoveModules() {
		this.container.addAbsorbingModule(this.absorbingModule1);
		this.container.addAbsorbingModule(this.absorbingModule2);
		this.container.addEnergyModule(this.energyModule1);
		this.container.addEnergyModule(this.energyModule2);
		
		Assert.assertEquals(2000000000L, this.container.getTotalHeatAbsorbing());
		Assert.assertEquals(4000000000L, this.container.getTotalEnergyOutput());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void addModuleToZeroCapacityContainer() {
		this.container = new ModuleContainer(0);
		this.container.addAbsorbingModule(this.absorbingModule1);
		this.container.addEnergyModule(this.energyModule1);
		
		Assert.assertEquals(2000000000L, this.container.getTotalHeatAbsorbing());
		Assert.assertEquals(4000000000L, this.container.getTotalEnergyOutput());
	}

}
