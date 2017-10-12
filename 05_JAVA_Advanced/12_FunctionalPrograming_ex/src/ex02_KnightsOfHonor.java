import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ex02_KnightsOfHonor {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bfr.readLine().split("\\s+");
		bfr.close();
		
		Consumer<String> printKnightsOfHonor = x -> System.out.println("Sir " + x);
		for (int i = 0; i < input.length; i++) {
			printKnightsOfHonor.accept(input[i]);
		}
		
	}

}
