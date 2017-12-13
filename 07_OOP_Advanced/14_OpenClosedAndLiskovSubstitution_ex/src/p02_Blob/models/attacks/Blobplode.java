package p02_Blob.models.attacks;

import p02_Blob.models.Blob;

public class Blobplode extends AbstractAttack {
	
	private final static int BLUBPLODE_HEALTH_DIVIDER = 2;
	private final static int BLUBPLODE_DAMAGE_MULTYPLYER = 2;
	private final static int DEFAULT_BLUBP_HEALTH = 1;
	
	@Override
    public void execute(Blob source, Blob target) {
		source.setHealth(source.getHealth() - (source.getHealth() / BLUBPLODE_HEALTH_DIVIDER));
		if (source.getHealth() < DEFAULT_BLUBP_HEALTH) {
			source.setHealth(DEFAULT_BLUBP_HEALTH);
		}
		target.setHealth(target.getHealth() - (source.getDamage() * BLUBPLODE_DAMAGE_MULTYPLYER));
    }
	
}
