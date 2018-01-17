package app.models.participants;

import app.contracts.Hero;

public abstract class AbstractHero extends AbstractTarget implements Hero {
	
	private int strength;
	private int dexterity;
	private int intelligence;
	
	protected AbstractHero() {
		super();
	}

	@Override
	public int getStrength() {
		return this.strength;
	}

	@Override
	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public int getDexterity() {
		return this.dexterity;
	}

	@Override
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	@Override
	public int getIntelligence() {
		return this.intelligence;
	}

	@Override
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

}
