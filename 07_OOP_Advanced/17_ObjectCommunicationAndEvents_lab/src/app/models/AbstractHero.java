package app.models;

import app.interfaces.Attacker;
import app.interfaces.Handler;
import app.interfaces.Observer;
import app.interfaces.Target;
import app.loggers.LogType;

public abstract class AbstractHero implements Attacker, Observer {

	private static final String TARGET_NULL_MESSAGE = "Target null";
	private static final String NO_TARGET_MESSAGE = "%s has no target";
	private static final String TARGET_DEAD_MESSAGE = "%s is dead";
	private static final String SET_TARGET_MESSAGE = "%s targets %s";

	private String id;
	private int dmg;
	private int xp;
	private Target target;
	private Handler handler;

	public AbstractHero(String id, int dmg, Handler handler) {
		this.id = id;
		this.dmg = dmg;
		this.handler = handler;
		this.xp = 0;
	}

	public void setTarget(Target target) {
		this.target = target;
		this.handler.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
	}

	public final void attack() {
		if (this.target == null) {
			this.handler.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
		} else if (this.target.isDead()) {
			this.handler.handle(LogType.EVENT, String.format(TARGET_DEAD_MESSAGE, target));
		} else {
			this.executeClassSpecificAttack(this.target, this.dmg);
		}
	}

	@Override
	public String toString() {
		return this.id;
	}
	

	@Override
	public void update(int value) {
		this.xp += value;
	}

	protected abstract void executeClassSpecificAttack(Target target, int dmg);

	protected Handler getHandler() {
		return this.handler;
	}

}
