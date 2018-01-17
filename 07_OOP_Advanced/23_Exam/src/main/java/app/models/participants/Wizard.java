package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends AbstractHero {

    private double gold;
    private int level;
    private double initialHealth;

    public Wizard(){
    	super();
    	this.level = 1;
    	this.gold = Config.HERO_START_GOLD;
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
        this.initialHealth = this.getStrength() * Config.HERO_HEALTH_MULTIPLIER;
        super.setHealth(this.initialHealth);
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

        StringBuilder result = new StringBuilder(this.getName() + " attacked!");
        if (!target.isAlive()) {
//            this.levelUp();
            target.giveReward(this);
            result.append(String.format(" %s has been slain by %s.", target.getName(), this.getName()));
        }

        return result.toString();
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public void giveReward(Targetable targetable) {
    	double reward = this.gold;
        this.gold = 0;
        targetable.receiveReward(reward);
    }
    
    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }
    
    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void levelUp() {
    	this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        super.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level++;
    }

	@Override
	public void takeDamage(double damage) {
		super.setHealth(super.getHealth() - damage);
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }

}
