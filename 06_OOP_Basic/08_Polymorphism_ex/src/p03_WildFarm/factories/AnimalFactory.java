package p03_WildFarm.factories;

import p03_WildFarm.animal.*;

public class AnimalFactory {

	public static Animal create(String[] tokens) {
		
		String animalType = tokens[0];
		String animalName = tokens[1];
		Double animalWeight = Double.parseDouble(tokens[2]);
		String livingRegion = tokens[3];
		
		switch (animalType.toLowerCase()) {
		case "tiger":
			return new Tiger(animalName, animalType, animalWeight, livingRegion);
		case "zebra":
			return new Zebra(animalName, animalType, animalWeight, livingRegion);
		case "mouse":
			return new Mouse(animalName, animalType, animalWeight, livingRegion);
		case "cat":
			String breed = tokens[4];
			return new Cat(animalName, animalType, animalWeight, livingRegion, breed);
		default:
			return null;
		}
		
	}
	
}
