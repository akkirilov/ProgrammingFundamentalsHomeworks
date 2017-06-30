import java.util.Scanner;

public class CensorEmailAddress {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split("\\@");
		String text = scanner.nextLine();
		scanner.close();
		
		String censoredEmail = tokens[0].replaceAll(".", "*") + "@" + tokens[1];		
		System.out.println(text.replaceAll("\\b" + tokens[0] + "@" + tokens[1] + "\\b", censoredEmail));
	
	}

}
