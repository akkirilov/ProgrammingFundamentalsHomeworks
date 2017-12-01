package p10_InfernoInfinity.controllers;

import java.util.Scanner;

public class Engine {

	private InfernoController controller;
	private Scanner scanner;

	public Engine() {
		this.controller = new InfernoController();
		this.scanner = new Scanner(System.in);
	}

	public void run() {

		String[] tokens = scanner.nextLine().split(";");
		while (!tokens[0].equalsIgnoreCase("end")) {

			switch (tokens[0]) {
			case "Create":
				controller.create(tokens[1], tokens[2]);
				break;
			case "Add":
				controller.add(tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
				break;
			case "Remove":
				controller.remove(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "Print":
				controller.print(tokens[1]);
				break;
			case "Compare":
				controller.compareWeapons(tokens[1], tokens[2]);
				break;
			default:
				break;
			}

			tokens = scanner.nextLine().split(";");
		}

		scanner.close();

	}

}
