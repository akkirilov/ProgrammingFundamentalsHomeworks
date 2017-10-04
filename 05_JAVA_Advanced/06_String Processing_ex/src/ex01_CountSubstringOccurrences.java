import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex01_CountSubstringOccurrences {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		String text = bfr.readLine().toLowerCase();
		String subText = bfr.readLine().toLowerCase();
		
		bfr.close();
		
		Integer index = text.indexOf(subText);
		Integer counter = 0;

        while (index != -1) {
            counter++;
            index = text.indexOf(subText, index + 1);
        }
		
		System.out.println(counter);
		
	}

}
