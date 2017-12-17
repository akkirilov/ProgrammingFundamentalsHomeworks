package app.models;

import app.interfaces.Attacker;
import app.interfaces.Handler;
import app.interfaces.Target;
import app.loggers.LogType;

public class Warrior extends AbstractHero implements Attacker {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
    	super.getHandler().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
