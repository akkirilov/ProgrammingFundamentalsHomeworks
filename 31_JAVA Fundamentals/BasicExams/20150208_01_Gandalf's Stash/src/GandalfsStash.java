import java.util.Arrays;
import java.util.Scanner;

public class GandalfsStash {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int gandalfsMood = Integer.parseInt(scanner.nextLine());
		
		String[] foods = Arrays.stream(scanner.nextLine().split("\\W+|_|\\d+"))
				.filter(x -> !x.equals(""))
				.map(String::toLowerCase)
				.toArray(String[]::new);
		
		for (int i = 0; i < foods.length; i++) {
			switch (foods[i]) {
				case "cram":
					gandalfsMood += 2;
					break;
				case "lembas":
					gandalfsMood += 3;
					break;
				case "apple":
					gandalfsMood += 1;
					break;
				case "melon":
					gandalfsMood += 1;
					break;
				case "honeycake":
					gandalfsMood += 5;
					break;
				case "mushrooms":
					gandalfsMood -= 10;
					break;
				default:
					gandalfsMood -= 1;
					break;
			}
		}

		String mood;
		if (gandalfsMood < -5) {
			mood = "Angry";
		} 
		else if (gandalfsMood < 0) {
			mood = "Sad";
		}
		else if (gandalfsMood <= 15) {
			mood = "Happy";
		}
		else {
			mood = "Special JavaScript mood";
		}
		
		System.out.printf("%d%n%s%n", gandalfsMood, mood);
	}
}