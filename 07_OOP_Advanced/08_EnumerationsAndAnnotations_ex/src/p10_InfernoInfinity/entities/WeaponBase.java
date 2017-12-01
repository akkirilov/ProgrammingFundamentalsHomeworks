package p10_InfernoInfinity.entities;

import p10_InfernoInfinity.enums.Gem;

public abstract class WeaponBase implements Weapon, Comparable<Weapon> {
	
	private String name;
	private int minDamage;
	private int maxDamage;
	private int numberOfSockets;
	private Gem[] gems;
	private int strengthBonus;
	private int agilityBonus;
	private int vitalityBonus;
	
	public WeaponBase(String name, int minDamage, int maxDamage, int numberOfSockets) {
		super();
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.numberOfSockets = numberOfSockets;
		this.gems = new Gem[numberOfSockets];
		this.strengthBonus = 0;
		this.agilityBonus = 0;
		this.vitalityBonus = 0;
	}
	
	@Override
	public double getWeaponLevel() {
		return ((this.minDamage + this.maxDamage) / 2.0) 
				+ this.strengthBonus 
				+ this.agilityBonus 
				+ this.vitalityBonus;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getNumberOfSockets() {
		return this.numberOfSockets;
	}

	@Override
	public void addGem(int socketIndex, Gem gem) {
		if (this.gems[socketIndex] != null) {
			this.removeGem(socketIndex);
		}
		if (gem.equals(this.gems[socketIndex])) {
			return;
		}
		this.gems[socketIndex] = gem;
		this.strengthBonus += gem.getStrength();
		this.agilityBonus += gem.getAgility();
		this.vitalityBonus += gem.getVitality();
		for (int i = 0; i < gem.getStrength(); i++) {
			this.minDamage += 2;
			this.maxDamage += 3;
		}
		for (int i = 0; i < gem.getAgility(); i++) {
			this.minDamage += 1;
			this.maxDamage += 4;
		}
	}

	@Override
	public void removeGem(int socketIndex) {
		if (this.gems[socketIndex] == null) {
			return;
		}
		Gem gem = this.gems[socketIndex];
		this.gems[socketIndex] = null;
		this.strengthBonus -= gem.getStrength();
		this.agilityBonus -= gem.getAgility();
		this.vitalityBonus -= gem.getVitality();
		for (int i = 0; i < gem.getStrength(); i++) {
			this.minDamage -= 2;
			this.maxDamage -= 3;
		}
		for (int i = 0; i < gem.getAgility(); i++) {
			this.minDamage -= 1;
			this.maxDamage -= 4;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponBase other = (WeaponBase) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String additionalPrint() {
		return String.format("%s (Item Level: %.1f)", this.toString(), this.getWeaponLevel()) ;
	}

	@Override
	public String toString() {
		return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality", 
				this.getName(),
				this.minDamage,
				this.maxDamage,
				this.strengthBonus,
				this.agilityBonus,
				this.vitalityBonus);
	}

	@Override
	public int compareTo(Weapon weapon) {
		return Double.compare(weapon.getWeaponLevel(), this.getWeaponLevel());
	}
	
}
