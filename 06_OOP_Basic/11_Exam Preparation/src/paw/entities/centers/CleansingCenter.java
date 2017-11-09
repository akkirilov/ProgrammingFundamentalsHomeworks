package paw.entities.centers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import paw.entities.animals.Animal;

public class CleansingCenter extends Center {

	private Map<String, List<Animal>> animals;
	
	public CleansingCenter(String name) {
		super(name);
		this.animals = new HashMap<>();
	}
	
	public void addAnimals(String name, List<Animal> animals) {
		this.animals.put(name, animals);
	}
	
	public Map<String, List<Animal>> cleanse () {
		Map<String, List<Animal>> temp = this.animals;
		for (Map.Entry<String, List<Animal>> e : temp.entrySet()) {
			for (Animal a : e.getValue()) {
				a.cleansing();
			}
		}
		this.animals = new HashMap<>();
		
		return temp;
	}
	
	public Map<String, List<Animal>> getAnimals() {
		return this.animals;
	}

	@Override
	public String toString() {
		return super.getName();
	}
}
