package paw.entities.centers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import paw.entities.animals.Animal;

public class AdoptionCenter extends Center {

	private List<Animal> animals;
	
	public AdoptionCenter(String name) {
		super(name);
		this.animals = new ArrayList<>();
	}
	
	public void register(Animal animal) {
		this.animals.add(animal);
	}
	
	public List<Animal> adopt() {
		List<Animal> cleaned = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getIsCleansing()) {
				cleaned.add(animals.get(i));
				animals.remove(i);
				i--;
			}
		}
		return cleaned;
	}
	
	public List<Animal> getUncleanedAnimals() {
		List<Animal> uncleaned = new ArrayList<>();
		for (int i = 0; i < animals.size(); i++) {
			if (!animals.get(i).getIsCleansing()) {
				uncleaned.add(animals.get(i));
				animals.remove(i);
				i--;
			}
		}
		return uncleaned;
	}

	public List<Animal> getAnimals() {
		return Collections.unmodifiableList(animals);
	}

	public void addCleanedAnimals(List<Animal> animals) {
		this.animals.addAll(animals);
	}

	@Override
	public String toString() {
		return super.getName();
	}
}
