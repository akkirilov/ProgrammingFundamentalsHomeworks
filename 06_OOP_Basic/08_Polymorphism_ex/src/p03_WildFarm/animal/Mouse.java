package p03_WildFarm.animal;

import p03_WildFarm.exceptions.FoodException;
import p03_WildFarm.food.Food;

public class Mouse extends Mammal {

	public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight, livingRegion);
	}

	@Override
	public String makeSound() {
		return "SQUEEEAAAK!";
	}

	@Override
	public void eat(Food food) throws FoodException {
		if (!"Vegetable".equals(food.getClass().getSimpleName())) {
            throw new FoodException("Mice are not eating that type of food!");
        }

        super.setFoodEaten(food.getQuantity());
	}

}
