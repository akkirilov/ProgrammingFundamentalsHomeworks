import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ex05_Palindromes {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] words = bfr.readLine().split(",\\s*|\\.\\s*|\\?\\s*|!\\s*|\\s+");

		bfr.close();
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		
		TreeSet<String> palindromes = new TreeSet<>();
		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				palindromes.add(words[i]);
			}
		}
		
		System.out.println(palindromes);
		
	}

	private static boolean isPalindrome(String word) {

		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}

}
