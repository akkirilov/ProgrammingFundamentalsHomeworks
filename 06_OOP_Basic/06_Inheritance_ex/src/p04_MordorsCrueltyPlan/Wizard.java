package p04_MordorsCrueltyPlan;

import java.util.ArrayList;
import java.util.List;

public class Wizard {
	
	private List<Food> eatenFood;

	public Wizard() {
		eatenFood = new ArrayList<>();
	}

	public long countFoodPoints() {
		long res = 0L;
		for (Food f : eatenFood) {
			res += f.getPoints();
		}
		return res;
	}
	
	public String getWizardMood() {
		long moodPoints = this.countFoodPoints();
		if (moodPoints < -5) {
			return "Angry";
		} else if (moodPoints < 0) {
			return "Sad";
		} else if (moodPoints < 15) {
			return "Happy";
		} else {
			return "JavaScript";
		}
	}

	public void addFood(Food food) {
		this.eatenFood.add(food);
	}
	
}
