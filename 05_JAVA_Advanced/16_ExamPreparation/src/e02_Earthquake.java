import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class e02_Earthquake {

	public static void main(String[] args) throws IOException {
		
		ArrayDeque<List<Short>> earthquakes = new ArrayDeque<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			List<Short> temp = new ArrayList<>();
			String[] input = reader.readLine().split("\\s+");
			for (int j = 0; j < input.length; j++) {
				temp.add(Short.parseShort(input[j]));
			}
			earthquakes.add(temp);
		}
		reader.close();

		Integer counter = 0;
		StringBuilder res = new StringBuilder();;
		List<Short> temp = null;
		while (!earthquakes.isEmpty()) {
			
			temp = earthquakes.pop();
			res.append(temp.get(0) + " ");
			counter++;
			if (temp.size() == 1) {
				continue;
			}
			for (int i = 1; i < temp.size(); i++) {
				if (temp.get(0) < temp.get(i)) {
					earthquakes.addLast(temp.subList(i, temp.size()));
					break;
				}
			}

		}

		System.out.println(counter);
		System.out.println(res.toString());

	}

}
