package p02_Blob.models.behavors;

import p02_Blob.models.Blob;

public class Inflated extends AbstractBehavior {

	private static final int INFLATED_HEALTH_DECREMENT = 10;
	private static final int INFLATED_HEALTH_POINTS = 50;

	public Inflated() {
		super();
	}

	@Override
	protected void applyTriggerEffect(Blob source) {
		source.setHealth(source.getHealth() + INFLATED_HEALTH_POINTS);
	}

	@Override
	public void takeTriggerEffect(Blob source) {
		if (super.isTriggered()) {
			source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
		}
	}

}
