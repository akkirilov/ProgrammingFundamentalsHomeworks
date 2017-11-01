package animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {

	protected List<Food> foodEaten = new ArrayList<>();
	
	public final void eat(Food food) {
		foodEaten.add(food);
	}
	
	public void eatAll(Food[] foods) {
		Collections.addAll(foodEaten, foods);
	}
	
}
