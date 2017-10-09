import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class lab01_MatchingBrackets {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String input = bfr.readLine();
		bfr.close();
		
		Deque<Integer> indexes = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) == '(') {
				indexes.push(i);
			} else if (input.charAt(i) == ')') {
				System.out.println(input.substring(indexes.pop(), i + 1));
			}
			
		}
		
	}

}
