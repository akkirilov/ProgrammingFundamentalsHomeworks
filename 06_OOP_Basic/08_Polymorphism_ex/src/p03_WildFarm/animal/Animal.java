package p03_WildFarm.animal;

import p03_WildFarm.exceptions.FoodException;
import p03_WildFarm.food.Food;

public abstract class Animal {

	private String animalName;
	private String animalType;
	private Double animalWeight;
	private Integer foodEaten;
	
	public Animal(String animalName, String animalType, Double animalWeight) {
		super();
		setAnimalName(animalName);
		setAnimalType(animalType);
		setAnimalWeight(animalWeight);
		this.foodEaten = 0;
	}

	protected String getAnimalName() {
		return animalName;
	}

	private void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	protected String getAnimalType() {
		return animalType;
	}

	private void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	protected Double getAnimalWeight() {
		return animalWeight;
	}

	private void setAnimalWeight(Double animalWeight) {
		this.animalWeight = animalWeight;
	}

	protected Integer getFoodEaten() {
		return foodEaten;
	}

	public void setFoodEaten(Integer foodEaten) {
		this.foodEaten = foodEaten;
	}

	public abstract void eat(Food food) throws FoodException;
	
	public abstract String makeSound();
	
}
