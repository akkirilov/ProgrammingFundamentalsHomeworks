package p02_KingsGambit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import p02_KingsGambit.contracts.Observer;
import p02_KingsGambit.models.FootMan;
import p02_KingsGambit.models.King;
import p02_KingsGambit.models.RoyalGuard;

public class Main {

	public static void main(String[] args) {
		
		Map<String, Observer> observers = new HashMap<>();

		Scanner scanner = new Scanner(System.in);
		
		King king = new King(scanner.nextLine());
		
		String[] units = scanner.nextLine().split("\\s+");
		for (String name : units) {
			Observer guard = new RoyalGuard(name);
			observers.putIfAbsent(name, guard);
			king.addObserver(guard);
		}
		units = scanner.nextLine().split("\\s+");
		for (String name : units) {
			Observer footMan = new FootMan(name);
			observers.putIfAbsent(name, footMan);
			king.addObserver(footMan);
		}
		
		while (true) {
			String[] tokens = scanner.nextLine().split("\\s+");
			if (tokens[0].equalsIgnoreCase("end")) {
				break;
			}
			
			switch (tokens[0]) {
			case "Attack":
				king.respondToAttack();
				break;
			case "Kill":
				king.removeObserver(observers.get(tokens[1]));
				observers.remove(tokens[1]);
				break;
			default:
				break;
			}
		}
		
		scanner.close();

	}

}
