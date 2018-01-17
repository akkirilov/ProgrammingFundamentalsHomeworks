package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractBoss extends AbstractTarget {
	
    private double gold;
    private int level;
    private double damage;

	protected AbstractBoss() {
		super();
		this.level = 1;
    	this.gold = Config.BOSS_GOLD;
    	this.damage = Config.BOSS_DAMAGE;
    	super.setHealth(Config.BOSS_HEALTH);
    	
	}
	
	@Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
//            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void receiveReward(double reward){
        this.gold += (reward * 0.1);
    }
    
    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
	public double getDamage() {
		return Config.BOSS_DAMAGE;
	}

	@Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
    }
    
    @Override
    public void levelUp() {
        super.setHealth(Config.BOSS_HEALTH);
        this.level++;
    }

	@Override
	public void takeDamage(double damage) {
		super.setHealth(super.getHealth() - damage);
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s | Class: %s%n"
				+ "Health: %.2f | Damage: %.2f | %.2f Gold", 
				super.getName(), this.getClass().getSimpleName(),
				super.getHealth(), this.getDamage(), this.getGold());
	}

}
