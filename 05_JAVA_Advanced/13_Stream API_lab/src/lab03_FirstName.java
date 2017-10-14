import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lab03_FirstName {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<String> names = Arrays.stream(reader.readLine().split("\\s+")).sorted().collect(Collectors.toList());
		
		List<String> chars = Arrays.stream(reader.readLine().split("\\s+")).map(String::toUpperCase).collect(Collectors.toList());
		
		reader.close();
		
		names = names.stream().filter(x -> chars.contains(x.charAt(0) + "")).collect(Collectors.toList());
		
		if (names.size() == 0) {
			System.out.println("No match");
		} else {
			System.out.println(names.get(0));
		}
		
	}

}
