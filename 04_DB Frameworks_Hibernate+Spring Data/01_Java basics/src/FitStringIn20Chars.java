import java.util.Scanner;

public class FitStringIn20Chars {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scanner.nextLine());
		scanner.close();
		
		if (sb.length() >= 20) {
			System.out.println(sb.substring(0, 20));
		} else {
			String stars = "********************";
			System.out.println(sb + stars.substring(0, 20 - sb.length()));
		}
		
	}

}
