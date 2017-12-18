package p02_KingsGambit.models;

import p02_KingsGambit.contracts.Killable;

public class RoyalGuard extends AbstractUnit implements Killable  {

	private boolean isDead;
	
	public RoyalGuard(String name) {
		super(name);
		this.isDead = false;
	}

	@Override
	public void update() {
		if (!isDead) {
			System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
		}
	}

	@Override
	public void die() {
		this.isDead = true;
	}

}
