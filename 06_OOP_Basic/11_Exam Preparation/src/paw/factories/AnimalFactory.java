package paw.factories;

import paw.entities.animals.Cat;
import paw.entities.animals.Dog;

public class AnimalFactory {
	
	public static Dog createDog(String name, int age, int learnedCommands) {
		return new Dog(name, age, learnedCommands);
	}
	
	public static Cat createCat(String name, int age, int intelligenceCoefficient) {
		return new Cat(name, age, intelligenceCoefficient);
	}
	
}
