package p09_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");

		List<TrafficLights> lights = new ArrayList<>();
		for (String s : tokens) {
			TrafficLights temp = TrafficLights.valueOf(s.toUpperCase());
			lights.add(temp);
		}

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			changeTrafficLights(lights);
			System.out.println(lights.toString().replaceAll("\\[|\\]|,", ""));
		}

		scanner.close();

	}

	private static void changeTrafficLights(List<TrafficLights> lights) {
		for (int i = 0; i < lights.size(); i++) {
			if (lights.get(i).equals(TrafficLights.GREEN)) {
				lights.set(i, TrafficLights.YELLOW);
			} else if (lights.get(i).equals(TrafficLights.RED)) {
				lights.set(i, TrafficLights.GREEN);
			} else {
				lights.set(i, TrafficLights.RED);
			}
		}
	}

}
