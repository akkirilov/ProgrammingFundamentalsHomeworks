import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class e01_Royalism {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().split("\\s+");
		reader.close();
		
		List<String> royals = new ArrayList<>();
		List<String> nonRoyals = new ArrayList<>();
		for (int i = 0; i < tokens.length; i++) {
			if (isRoyal(tokens[i])) {
				royals.add(tokens[i]);
			} else {
				nonRoyals.add(tokens[i]);
			}
		}
		
		if (royals.size() >= nonRoyals.size()) {
			System.out.println("Royalists - " + royals.size());
			for (String s : royals) {
				System.out.println(s);
			}
			System.out.println("All hail Royal!");
		} else {
			for (String s : nonRoyals) {
				System.out.println(s);
			}
			System.out.println("Royalism, Declined!");
		}
		
	}

	private static boolean isRoyal(String name) {
		Integer sum = 0;
		for (int i = 0; i < name.length(); i++) {
			sum += name.charAt(i);
			while (sum > 26) {
				sum -= 26;
			}
		}
		if (sum == 18) {
			return true;
		} else {
			return false;
		}
	}

}
