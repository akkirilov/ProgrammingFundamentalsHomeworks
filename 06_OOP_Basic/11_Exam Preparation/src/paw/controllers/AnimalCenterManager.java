package paw.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import paw.entities.animals.Animal;
import paw.entities.centers.AdoptionCenter;
import paw.entities.centers.CastrationCenter;
import paw.entities.centers.CleansingCenter;
import paw.factories.AnimalFactory;
import paw.factories.CenterFactory;

public class AnimalCenterManager {

	private Map<String, AdoptionCenter> adoptionCenters;
	private Map<String, CleansingCenter> cleansingCenters;
	private Map<String, CastrationCenter> castrationCenters;
	private List<Animal> addoptedAnimals;
	private List<Animal> cleansingAnimals;
	private List<Animal> castratedAnimals;

	public AnimalCenterManager() {
		super();
		this.adoptionCenters = new HashMap<>();
		this.cleansingCenters = new HashMap<>();
		this.castrationCenters = new HashMap<>();
		this.addoptedAnimals = new ArrayList<>();
		this.cleansingAnimals = new ArrayList<>();
		this.castratedAnimals = new ArrayList<>();
	}

	public void registerCleansingCenter(String name) {
		cleansingCenters.put(name, CenterFactory.createCleansingCenter(name));
	}

	public void registerAdoptionCenter(String name) {
		adoptionCenters.put(name, CenterFactory.createAdoptionCenter(name));
	}
	
	public void registerCastrationCenter(String name) {
		castrationCenters.put(name, CenterFactory.createCastrationCenter(name));
	}

	public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
		adoptionCenters.get(adoptionCenterName)
				.register(AnimalFactory.createDog(name, age, learnedCommands));
	}

	public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
		adoptionCenters.get(adoptionCenterName)
				.register(AnimalFactory.createCat(name, age, intelligenceCoefficient));
	}

	public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
		cleansingCenters.get(cleansingCenterName).addAnimals(adoptionCenterName,
				adoptionCenters.get(adoptionCenterName).getUncleanedAnimals());
	}
	
	public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
		castrationCenters.get(castrationCenterName).addAnimals(adoptionCenterName,
				adoptionCenters.get(adoptionCenterName).getUncleanedAnimals());
	}

	public void cleanse(String cleansingCenterName) {
		Map<String, List<Animal>> returnedAnimals = cleansingCenters.get(cleansingCenterName).cleanse();
		for (Map.Entry<String, List<Animal>> entry : returnedAnimals.entrySet()) {
			cleansingAnimals.addAll(entry.getValue());
			adoptionCenters.get(entry.getKey()).addCleanedAnimals(entry.getValue());
		}
	}
	
	public void castrate(String castrationCenterName) {
		Map<String, List<Animal>> returnedAnimals = castrationCenters.get(castrationCenterName).castrate();
		for (Map.Entry<String, List<Animal>> entry : returnedAnimals.entrySet()) {
			castratedAnimals.addAll(entry.getValue());
			adoptionCenters.get(entry.getKey()).addCleanedAnimals(entry.getValue());
		}
	}

	public void adopt(String adoptionCenterName) {
		addoptedAnimals.addAll(adoptionCenters.get(adoptionCenterName).adopt());
	}

	public void printStatistics() {
		String addoptedAnimalsString = "None";
		if (addoptedAnimals.size() > 0) {
			addoptedAnimals = addoptedAnimals.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
			addoptedAnimalsString = addoptedAnimals.toString().replaceAll("\\[|\\]", "");
			
		}
		String cleansingAnimalsString = "None";
		if (cleansingAnimals.size() > 0) {
			cleansingAnimals = cleansingAnimals.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
			cleansingAnimalsString = cleansingAnimals.toString().replaceAll("\\[|\\]", "");
		}
		
		StringBuilder sb = new StringBuilder("Paw Incorporative Regular Statistics\r\nAdoption Centers: ");
		sb.append(adoptionCenters.size()).append("\r\nCleansing Centers: ").append(cleansingCenters.size())
				.append("\r\nAdopted Animals: ").append(addoptedAnimalsString)
				.append("\r\nCleansed Animals: ").append(cleansingAnimalsString)
				.append("\r\nAnimals Awaiting Adoption: ").append(this.getAnimalsForAdoption())
				.append("\r\nAnimals Awaiting Cleansing: ").append(this.getAnimalsForCleansing());
		System.out.println(sb.toString());
	}

	private int getAnimalsForAdoption() {
		int res = 0;
		for (Map.Entry<String, AdoptionCenter> entry : adoptionCenters.entrySet()) {
			for (Animal animal : entry.getValue().getAnimals()) {
				if (animal.getIsCleansing()) {
					res++;
				}
			}
		}
		return res;
	}

	private int getAnimalsForCleansing() {
		int res = 0;
		for (Map.Entry<String, CleansingCenter> entry : cleansingCenters.entrySet()) {
			for (Map.Entry<String, List<Animal>> c : entry.getValue().getAnimals().entrySet()) {
				for (Animal animal : c.getValue()) {
					if (!animal.getIsCleansing()) {
						res++;
					}
				}
			}
		}
		return res;
		
	}

	public void printCastrateStatistics() {
		castratedAnimals = castratedAnimals.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
		String castratedAnimalsString = castratedAnimals.toString().replaceAll("\\[|\\]", "");
		if (castratedAnimalsString.length() < 1) {
			castratedAnimalsString = "None";
		}
		StringBuilder sbb = new StringBuilder("Paw Inc. Regular Castration Statistics\r\nCastration Centers: ");
				sbb.append(castrationCenters.size())
				.append("\r\nCastrated Animals: ").append(castratedAnimalsString);
		
		System.out.println(sbb.toString());
	}

}
