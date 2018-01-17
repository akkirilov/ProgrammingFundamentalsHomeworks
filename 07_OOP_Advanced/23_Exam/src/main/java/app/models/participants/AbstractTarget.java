package app.models.participants;

import app.contracts.Targetable;

public abstract class AbstractTarget implements Targetable {
	
	private String name;
	private double health;
	private boolean isAlive;
	
	protected AbstractTarget() {
		this.isAlive = true;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
	}

	@Override
	public boolean isAlive() {
		if (this.health <= 0) {
			this.isAlive = false;
		}
		return this.isAlive;
	}

}
