package p08_MilitaryElite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import p08_MilitaryElite.soldiers.*;
import p08_MilitaryElite.soldiers.spies.*;
import p08_MilitaryElite.soldiers.privates.*;
import p08_MilitaryElite.soldiers.privates.leutenantGenerals.*;
import p08_MilitaryElite.soldiers.privates.specialSoldiers.commandos.*;
import p08_MilitaryElite.soldiers.privates.specialSoldiers.engineers.*;

public class Main {

	private static Map<String, Private> privates = new HashMap<>();
	private static List<Soldier> soldiers = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("End")) {

			create(tokens);

			tokens = scanner.nextLine().split("\\s+");
		}

		scanner.close();

		for (Soldier soldier : soldiers) {
			printSoldier(soldier);
		}

	}

	private static void create(String[] tokens) {

		String id = tokens[1];
		String firstName = tokens[2];
		String lastName = tokens[3];
		double salary = Double.parseDouble(tokens[4]);

		String corp;
		Soldier soldier = null;

		switch (tokens[0]) {
		case "Private":
			Private soldierPrivate = new Private(id, firstName, lastName, salary);
			soldier = soldierPrivate;
			privates.put(id, soldierPrivate);
			break;
		case "Commando":
			corp = tokens[5];
			if (!corp.equals("Airforces") && !corp.equals("Marines")) {
				return;
			}
			List<Mission> missions = new ArrayList<>();
			for (int i = 6; i < tokens.length; i += 2) {
				if (!tokens[i + 1].equals("Finished") && !tokens[i + 1].equals("inProgress")) {
					continue;
				}
				missions.add(new Mission(tokens[i], tokens[i + 1]));
			}
			soldier = new Commando(id, firstName, lastName, salary, corp, missions);
			break;
		case "Engineer":
			corp = tokens[5];
			if (!corp.equals("Airforces") && !corp.equals("Marines")) {
				return;
			}
			List<Repair> repairs = new ArrayList<>();
			for (int i = 6; i < tokens.length; i += 2) {
				repairs.add(new Repair(tokens[i], Integer.parseInt(tokens[i + 1])));
			}
			soldier = new Engineer(id, firstName, lastName, salary, corp, repairs);
			break;
		case "LeutenantGeneral":
			List<Private> privatesList = new ArrayList<>();
			for (int i = 5; i < tokens.length; i++) {
				privatesList.add(privates.get(tokens[i]));
			}
			soldier = new LeutenantGeneral(id, firstName, lastName, salary, privatesList);
			break;
		case "Spy":
			soldier = new Spy(id, firstName, lastName, tokens[4]);
			break;
		default:
			break;
		}
//		printSoldier(soldier);
		if (soldier != null) {
			soldiers.add(soldier);
		}

	}

	private static void printSoldier(Soldier soldier) {
		System.out.println(soldier.toString().trim());
	}

}
