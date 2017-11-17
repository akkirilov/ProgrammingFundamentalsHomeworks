package p10_MooD3;

import java.util.Scanner;

import p10_MooD3.gameObjects.GameObject;
import p10_MooD3.gameObjects.archangels.Archangel;
import p10_MooD3.gameObjects.demons.Demon;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split("\\s+\\|\\s+");
		scanner.close();
		
		GameObject gameObject = createGameObject(tokens);
		
		System.out.println(gameObject);
		
	}

	private static GameObject createGameObject(String[] tokens) {
		
		String username = tokens[0];
		String type = tokens[1];
		int level = Integer.parseInt(tokens[3]);
		
		switch (type) {
		case "Demon":
			return new Demon(username, level, Double.parseDouble(tokens[2]));
		case "Archangel":
			return new Archangel(username, level, Integer.parseInt(tokens[2]));
		default:
			return null;
		}
		
	}

}
