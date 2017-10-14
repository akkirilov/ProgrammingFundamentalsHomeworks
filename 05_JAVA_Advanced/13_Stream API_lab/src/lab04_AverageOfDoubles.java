import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class lab04_AverageOfDoubles {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		OptionalDouble avg = Arrays.stream(reader.readLine().split("\\s+"))
				.filter(x -> !x.isEmpty())
				.mapToDouble(Double::parseDouble)
				.average();
		
		reader.close();
		
		if (avg.isPresent()) {
			System.out.printf("%.2f%n", avg.getAsDouble());
		} else {
			System.out.println("No match");
		}
		
	}

}
