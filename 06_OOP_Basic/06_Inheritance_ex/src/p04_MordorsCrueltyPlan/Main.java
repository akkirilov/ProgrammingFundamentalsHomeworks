package p04_MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		Wizard gandalfTheGray = new Wizard();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = reader.readLine().split("\\s+");
		for (String f : tokens) {
			gandalfTheGray.addFood(getFoodFromString(f));
		}
		
		System.out.println(gandalfTheGray.countFoodPoints());
		System.out.println(gandalfTheGray.getWizardMood());

		reader.close();

	}

	private static Food getFoodFromString(String f) {
		f = f.toLowerCase();
		switch (f) {
		case "cram":
			return new Cram();
		case "lembas":
			return new Lembas();
		case "apple":
			return new Apple();
		case "honeycake":
			return new HoneyCake();
		case "mushrooms":
			return new Mushrooms();
		case "melon":
			return new Melon();
		default:
			return new EverythingElse();
		}
	}

}
