import java.util.Scanner;

public class lab03_ParseTags {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		scanner.close();
		
		Integer index = -1;
		StringBuffer correctedText = new StringBuffer();
		while (text.contains("<upcase>")) {
			
			index = text.indexOf("<upcase>");
			correctedText.append(text.substring(0, index));
			text = text.substring(index + 8, text.length());
			index = text.indexOf("</upcase>");
			correctedText.append((text.substring(0, index)).toUpperCase());
			text = text.substring(index + 9, text.length());
		}
		
		correctedText.append(text);
		
		System.out.println(correctedText.toString());
		
	}

}
