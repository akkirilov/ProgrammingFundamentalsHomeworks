import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ex11_PredicateParty {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		Predicate<String> isCommandRemove = x -> x.equals("Remove");
		Predicate<String> isCommandDouble = x -> x.equals("Double");
		Predicate<String> condition;
		Consumer<List<String>> printGuests = x -> System.out.println(x.toString().replaceAll("\\[|\\]", "") + " are going to the party!");

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = bfr.readLine().split("\\s+");
		LinkedList<String> guests = new LinkedList<>(Arrays.asList(input));
		
		input = bfr.readLine().split("\\s+");
		while (!input[0].equals("Party!")) {
			
			String command = input[0];
			String criteria = input[1];
			String givenString = input[2];
			
			if (criteria.equals("StartsWith")) {
				condition = x -> x.startsWith(givenString);
			} else if (criteria.equals("EndsWith")) {
				condition = x -> x.endsWith(givenString);
			} else {
				Integer givenLength = parseInteger.apply(givenString);
				condition = x -> x.length() == givenLength;
			}
			
			if (isCommandRemove.test(command)) {
				for (int i = 0; i < guests.size(); i++) {
					if (condition.test(guests.get(i))) {
						guests.remove(i);
						i--;
					}
				}
			} else if (isCommandDouble.test(command)) {
				for (int i = 0; i < guests.size(); i++) {
					if (condition.test(guests.get(i))) {
						guests.add(i, guests.get(i));
						i++;
					}
				}
			}
			
			input = bfr.readLine().split("\\s+");
		}
		
		bfr.close();
		
		if (guests.isEmpty()) {
			System.out.println("Nobody is going to the party!");
		} else {
			printGuests.accept(guests);
			
		}

	}

}
