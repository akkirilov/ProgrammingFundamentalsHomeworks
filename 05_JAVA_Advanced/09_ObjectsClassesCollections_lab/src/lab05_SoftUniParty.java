import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class lab05_SoftUniParty {

	public static void main(String[] args) throws IOException {

		Set<String> vipGuests = new TreeSet<>();
		Set<String> regularGuests = new TreeSet<>();

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String input = bfr.readLine();
		while (!input.equals("PARTY")) {

			if (input.length() != 8) {
				continue;
			}

			if (Character.isDigit(input.charAt(0))) {
				vipGuests.add(input);
			} else {
				regularGuests.add(input);
			}

			input = bfr.readLine();

		}

		input = bfr.readLine();
		while (!input.equals("END")) {

			if (vipGuests.contains(input)) {
				vipGuests.remove(input);
			} else {
				regularGuests.remove(input);
			}

			input = bfr.readLine();

		}

		bfr.close();
		
		System.out.println(vipGuests.size() + regularGuests.size());
		for (String g : vipGuests) {
			System.out.println(g);
		}
		for (String g : regularGuests) {
			System.out.println(g);
		}

	}

}
