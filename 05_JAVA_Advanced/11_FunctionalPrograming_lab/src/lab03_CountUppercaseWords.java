import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class lab03_CountUppercaseWords {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String[] words = bfr.readLine().split("\\s+");
		
		bfr.close();
		
		Predicate<String> isUppercaseWords = x -> x.charAt(0) == x.toUpperCase().charAt(0);
		Consumer<String> printWord = x -> System.out.println(x);
		
		List<String> uppercaseWords = new LinkedList<>();
		for (int i = 0; i < words.length; i++) {
			if (isUppercaseWords.test(words[i])) {
				uppercaseWords.add(words[i]);
			}
		}
		
		System.out.println(uppercaseWords.size());
		uppercaseWords.stream().forEach(printWord);
		
	}

}
