import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ex12_Inferno {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> items = new LinkedList<>(Arrays.asList(Arrays.stream(bfr.readLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new)));
		items.add(0, 0);
		
		List<String> filters = new LinkedList<>();

		String[] input = bfr.readLine().split(";");
		while (!input[0].equals("Forge")) {

			String command = input[0];
			String type = input[1];
			String parameter = input[2];
			String filter = type + ";" + parameter;
			
			if (command.equals("Exclude")) {
				filters.add(filter);
			} else if (command.equals("Reverse")) {
				if (filters.contains(filter)) {
					filters.remove(filter);
				}
			}

			input = bfr.readLine().split(";");
		}

		bfr.close();
		
		items.addLast(0);
		
		List<Integer> indexes = new ArrayList<>();
		for (int i = 0; i < filters.size(); i++) {
			String[] filterTokens = filters.get(i).split(";");
			String filter = filterTokens[0];
			Integer parameter = Integer.parseInt(filterTokens[1].split("\\s+")[filterTokens[1].split("\\s+").length - 1]);
			
			if (filter.equals("Sum Left")) {
				for (int j = 1; j < items.size(); j++) {
					if (items.get(j - 1) + items.get(j) == parameter) {
						indexes.add(j);
					}
				}
			} else if (filter.equals("Sum Right")) {
				for (int j = 0; j < items.size() - 1; j++) {
					if (items.get(j + 1) + items.get(j) == parameter) {
						indexes.add(j);
					}
				}
			} else if (filter.equals("Sum Left Right")) {
				for (int j = 1; j < items.size() - 1; j++) {
					if (items.get(j - 1) + items.get(j + 1) + items.get(j) == parameter) {
						indexes.add(j);
					}
				}
			} else {
				continue;
			}

			//guests.removeIf(condition);

		}
				
		for (int i = 1; i < items.size() - 1; i++) {
			if (!indexes.contains(i)) {
				System.out.print(items.get(i) + " ");
			}
		}

		//System.out.println(items.toString().replaceAll("\\[|\\]|,", ""));

	}

}
