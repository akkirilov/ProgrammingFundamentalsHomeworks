import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int keyNum = Integer.parseInt(scanner.nextLine());
		
		int turns = keyNum / 26;
		int symbol = keyNum % 26;
		if (symbol == 0) {
			symbol += 26;
			turns -= 1;
		}

		char keyChar = ' '; 
		if(turns % 2 == 0){
			keyChar = (char)(('a' - 1) + symbol);
		}
		else{
			keyChar = (char)(('A' - 1) + symbol);
		}
		
		String key = "" + keyChar + keyChar;
		Pattern pattern = Pattern.compile(key + "(.*?)" + key);
		
		String allLines = "";
		String line = scanner.nextLine();
		while (!line.equals("End")) {
			allLines += line;
			line = scanner.nextLine();
		}

		Matcher match = pattern.matcher(allLines);
		while (match.find()) {
			String toPrint = match.group().toString().replace(key, "");
			if (!toPrint.equals("")) {
				System.out.println(toPrint);
			}
		}
	}
}