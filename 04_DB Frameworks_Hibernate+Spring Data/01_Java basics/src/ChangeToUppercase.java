import java.util.Scanner;

public class ChangeToUppercase {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scanner.nextLine());
		scanner.close();
		
		int start;
		int end;
		String word;
		while (sb.toString().contains("<upcase>")) {
			start = sb.indexOf("<upcase>");
			end = sb.indexOf("</upcase>");
			word = sb.substring(start + 8, end).toUpperCase();
			
			sb.replace(start  + 8, end, word);
			sb.delete(start, start + 8);
			sb.delete(end - 8, end + 1);
		}
		
		System.out.printf("%s%n", sb);
		
	}

}
