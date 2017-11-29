package p08_PetClinics.entities;

import java.util.HashMap;
import java.util.Map;

public class ClinicManager {
	
	private Map<String, Clinic> clinics;
	private Map<String, Pet> pets;

	public ClinicManager() {
		this.clinics = new HashMap<>();
		this.pets = new HashMap<>();
	}
	
	public void createPet(String name, Integer age, String kind) {
		this.pets.put(name, new Pet(name, age, kind));
	}
	
	public void createClinic(String name, Integer roomCounter) {
		if (roomCounter % 2 == 0) {
			System.out.println("Invalid Operation!");
			return;
		}
		this.clinics.put(name, new ClinicImpl(name, roomCounter));
	}
	
	public boolean addPet(String petName, String clinicName) {
		if (!clinics.containsKey(clinicName) || !pets.containsKey(petName)) {
			return false;
		}
		return clinics.get(clinicName).addPet(pets.remove(petName));
	}
	
	public boolean releasePet(String clinicName) {
		if (!clinics.containsKey(clinicName)) {
			return false;
		}
		return clinics.get(clinicName).release();
	}
	
	public boolean hasEmptyRooms(String clinicName) {
		if (!clinics.containsKey(clinicName)) {
			return false;
		}
		return clinics.get(clinicName).hasEmptyRooms();
	}
	
	public void print(String... printArgs) {
		String clinicName = printArgs[1];
		if (!clinics.containsKey(clinicName)) {
			System.out.println("Invalid Operation!");
		}
		if (printArgs.length == 2) {
			clinics.get(clinicName).printClinic();
		} else {
			Integer room = Integer.parseInt(printArgs[2]);
			clinics.get(clinicName).printRoom(room);
		}
	}
	
}
