package p02_KingsGambit.models;

import p02_KingsGambit.contracts.Killable;
import p02_KingsGambit.contracts.Observer;

public class FootMan extends AbstractUnit implements Killable, Observer {

	private boolean isDead;

	public FootMan(String name) {
		super(name);
		this.isDead = false;
	}

	@Override
	public void update() {
		if (!isDead) {
			System.out.println(String.format("Footman %s is panicking!", super.getName()));
		}
	}

	@Override
	public void die() {
		this.isDead = true;
	}

}
