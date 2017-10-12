import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ex12_ThePartyReservationFilterModule {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bfr.readLine().split("\\s+");
		LinkedList<String> guests = new LinkedList<>(Arrays.asList(input));
		List<String> filters = new LinkedList<>();
		
		input = bfr.readLine().split(";");
		while (!input[0].equals("Print")) {

			String command = input[0];
			String type = input[1];
			String parameter = input[2];
			String filter = type + " " + parameter;

			if (filters.contains(filter)) {
				input = bfr.readLine().split(";");
				continue;
			}

			if (command.startsWith("Add")) {
				filters.add("Add " + filter);
			} else if (command.startsWith("Remove")) {
				if (filters.contains("Add " + filter)) {
					filters.remove("Add " + filter);
				}
			}

			input = bfr.readLine().split(";");
		}

		bfr.close();
		
		Predicate<String> condition = x -> x.startsWith("TTT");

		for (int i = 0; i < filters.size(); i++) {
			String[] filterTokens = filters.get(i).split("\\s");
			String filter = filterTokens[1];
			
			if (filter.equals("Starts")) {
				condition = x -> x.startsWith(filterTokens[3]);
			} else if (filter.equals("Ends")) {
				condition = x -> x.endsWith(filterTokens[3]);
			} else if (filter.equals("Contains")) {
				condition = x -> x.contains(filterTokens[2]);
			} else if (filter.equals("Length")) {
				condition = x -> x.length() == Integer.parseInt(filterTokens[2]);
			} else {
				continue;
			}
			
			guests.removeIf(condition);
			
		}
		
		System.out.println(guests.toString().replaceAll("\\[|\\]|,", ""));

	}

}
