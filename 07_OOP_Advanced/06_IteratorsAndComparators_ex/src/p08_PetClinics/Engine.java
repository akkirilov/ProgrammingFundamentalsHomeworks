package p08_PetClinics;

import java.util.Scanner;

import p08_PetClinics.entities.ClinicManager;

public class Engine {
	
	private ClinicManager manager;
	private Scanner scaner;

	public Engine() {
		this.manager = new ClinicManager();
		this.scaner = new Scanner(System.in);
	}

	public void run() {
		
		Integer commandCounter = Integer.parseInt(this.scaner.nextLine());
		for (int i = 0; i < commandCounter; i++) {
			
			String[] tokens = scaner.nextLine().split("\\s+");
			switch (tokens[0]) {
			case "Create":
				if (tokens[1].equals("Pet")) {
					this.manager.createPet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
				} else {
					this.manager.createClinic(tokens[2], Integer.parseInt(tokens[3]));
				}
				break;
			case "HasEmptyRooms":
				System.out.println(manager.hasEmptyRooms(tokens[1]));
				break;
			case "Add":
				System.out.println(manager.addPet(tokens[1], tokens[2]));
				break;
			case "Release":
				System.out.println(manager.releasePet(tokens[1]));
				break;
			case "Print":
				manager.print(tokens);
				break;
			default:
				break;
			}
			
		}
		
		this.scaner.close();
	}
	
}
