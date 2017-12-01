package p10_InfernoInfinity.entities;

import p10_InfernoInfinity.enums.Gem;

public interface Weapon extends Comparable<Weapon> {

	public String getName();
	
	public int getNumberOfSockets();
	
	public double getWeaponLevel();
	
	public void addGem(int index, Gem gem);

	public void removeGem(int socketIndex);
	
	public String additionalPrint();
	
}
