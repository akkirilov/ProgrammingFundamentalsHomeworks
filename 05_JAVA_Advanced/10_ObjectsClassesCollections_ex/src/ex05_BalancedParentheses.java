import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ex05_BalancedParentheses {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String input = bfr.readLine();
		bfr.close();

		Deque<Character> chars = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			
			char next = input.charAt(i);
			if (next == '(' || next == '[' || next == '{') {
				chars.push(next);
			} else {
				if (chars.isEmpty()) {
					System.out.println("NO");
					return;
				}
				
				char pop = chars.pop();
				if (next == ')' && pop != '(') {
					System.out.println("NO");
					return;
				} else if (next == ']' && pop != '[') {
					System.out.println("NO");
					return;
				} else if (next == '}' && pop != '{') {
					System.out.println("NO");
					return;
				}
			}

		}
		
		System.out.println("YES");
		
	}

}
