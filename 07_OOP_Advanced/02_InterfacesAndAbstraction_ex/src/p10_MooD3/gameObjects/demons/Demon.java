package p10_MooD3.gameObjects.demons;

import p10_MooD3.gameObjects.GameObject;
import p10_MooD3.gameObjects.GameObjectBase;

public class Demon extends GameObjectBase implements GameObject {

	public Demon(String username, int level, double energy) {
		super(username, level);
		this.setHashedPassword();
		this.setEnergy(energy);
	}

	private void setHashedPassword() {
		super.setHashedPassword(String.valueOf(super.getUsername().length() * 217));
	}

	private void setEnergy(double energy) {
		super.setSpecialPoints(String.valueOf(super.getLevel() * energy));
	}

}
