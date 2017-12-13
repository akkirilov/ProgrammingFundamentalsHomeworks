package p02_Blob.models.behavors;

import p02_Blob.models.Blob;

public class Aggressive extends AbstractBehavior {

	private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
	private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

	private Integer sourceInitialDamage;

	public Aggressive() {
		super();
	}

	@Override
	protected void applyTriggerEffect(Blob source) {
		if (this.sourceInitialDamage == null) {
			this.sourceInitialDamage = source.getDamage();
		}
		source.setDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
	}

	@Override
	public void takeTriggerEffect(Blob source) {
		if (super.isTriggered()) {
			source.setDamage(source.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);
			if (source.getDamage() <= this.sourceInitialDamage) {
				source.setDamage(this.sourceInitialDamage);
			}
		}

	}

}
