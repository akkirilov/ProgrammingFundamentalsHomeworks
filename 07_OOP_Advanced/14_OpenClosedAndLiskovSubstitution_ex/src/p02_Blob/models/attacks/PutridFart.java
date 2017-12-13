package p02_Blob.models.attacks;

import p02_Blob.models.Blob;

public class PutridFart extends AbstractAttack {

	@Override
    public void execute(Blob source, Blob target) {
		target.setHealth(target.getHealth() - source.getDamage());
    }
	
}
