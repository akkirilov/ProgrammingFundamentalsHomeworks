package p03_WildFarm.animal;

import p03_WildFarm.exceptions.FoodException;
import p03_WildFarm.food.Food;

public class Cat extends Felime {

	private String breed;
	
	public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
		super(animalName, animalType, animalWeight, livingRegion);
		setBreed(breed);
	}

	protected String getBreed() {
		return breed;
	}

	private void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Override
	public String makeSound() {
		return "Meowwww";
	}

	@Override
	public String toString() {
		return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                super.PRINT_DISTANCE_FORMAT.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
	}

	@Override
	public void eat(Food food) throws FoodException {
        super.setFoodEaten(food.getQuantity());
	}

}
