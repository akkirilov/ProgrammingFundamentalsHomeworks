package p10_MooD3.gameObjects.archangels;

import p10_MooD3.gameObjects.GameObject;
import p10_MooD3.gameObjects.GameObjectBase;

public class Archangel extends GameObjectBase implements GameObject {
	
	public Archangel(String username, int level, int energy) {
		super(username, level);
		this.setHashedPassword();
		this.setMana(energy);
	}

	private void setHashedPassword() {
		super.setHashedPassword(new StringBuilder(super.getUsername()).reverse()
				.append(super.getUsername().length() * 21)
				.toString());
	}

	private void setMana(int energy) {
		super.setSpecialPoints(String.valueOf(super.getLevel() * energy));
	}

}
