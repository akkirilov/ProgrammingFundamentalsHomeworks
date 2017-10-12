import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class ex05_AppliedArithmetic {

	public static void main(String[] args) throws IOException {
		
		Function<String, Integer> parseInteger = x -> Integer.parseInt(x);
		
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Integer[] input = Arrays.stream(bfr.readLine().split("\\s+")).map(parseInteger).toArray(Integer[]::new);
		
		StringBuilder result = new StringBuilder();
		String command = bfr.readLine();
		while (!command.equals("end")) {
			
			switch (command) {
			case "add":
				input = Arrays.stream(input).map(x -> x += 1).toArray(Integer[]::new);
				break;
			case "subtract":
				input = Arrays.stream(input).map(x -> x -= 1).toArray(Integer[]::new);
				break;
			case "multiply":
				input = Arrays.stream(input).map(x -> x *= 2).toArray(Integer[]::new);
				break;
			case "print":
				for (int i = 0; i < input.length; i++) {
                    result.append(input[i] + " ");
                }
                result.append("\r\n");
				break;
			default:
				break;
			}
			
			command = bfr.readLine();
		}
		
		bfr.close();
		
		System.out.println(result.toString());
		
	}

}
