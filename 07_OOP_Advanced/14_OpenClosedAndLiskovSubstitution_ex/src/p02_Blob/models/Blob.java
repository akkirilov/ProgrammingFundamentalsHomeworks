package p02_Blob.models;

import p02_Blob.interfaces.Attack;
import p02_Blob.interfaces.Behavior;

public class Blob {

	private String name;
	private int health;
	private int damage;
	private Behavior behavior;
	private Attack attack;
	private int initialHealth;

	public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.behavior = behavior;
		this.attack = attack;
		this.initialHealth = health;
	}

	public Behavior getBehavior() {
		return this.behavior;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
		if (this.health < 0) {
			this.health = 0;
		}
		if (this.health <= (this.initialHealth / 2) && !this.behavior.isTriggered()) {
			this.behavior.triggerBehavior(this);
		}
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int currentDamage) {
		this.damage = currentDamage;
	}

	public void attack(Blob target) {
		if (!this.behavior.isTriggered()) {
			this.behavior.takeTriggerEffect(this);
			target.behavior.takeTriggerEffect(target);
			this.attack.execute(this, target);
		} else {
			target.behavior.takeTriggerEffect(target);
			this.attack.execute(this, target);
			this.behavior.takeTriggerEffect(this);
		}
	}

	public void makeTurn() {
		this.behavior.takeTriggerEffect(this);
	}

	@Override
	public String toString() {
		if (this.getHealth() <= 0) {
			return String.format("Blob %s KILLED", this.name);
		}

		return String.format("Blob %s: %s HP, %s Damage", this.name, this.getHealth(), this.getDamage());
	}

}
