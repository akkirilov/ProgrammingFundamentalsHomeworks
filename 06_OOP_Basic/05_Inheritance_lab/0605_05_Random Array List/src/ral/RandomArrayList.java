package ral;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList {
	
	private final Random RND = new Random();

	public Object getRandomElement() {
		Random random = new Random();
		return (Object) super.remove(RND.nextInt(super.size()));
	}

}
