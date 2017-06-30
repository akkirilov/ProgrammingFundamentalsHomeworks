
import java.util.Scanner;

public class URLParser {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scanner.nextLine());
		scanner.close();
		
		int i = 0;
				
		String protocol = "";
		if (sb.toString().contains("://")) {
			i = sb.indexOf("://");
			protocol = sb.substring(0, i);
			sb.delete(0, i + 3);
		}
		
		String server = "";
		if (sb.toString().contains(".") || sb.toString().contains("/")) {
			i = sb.indexOf("/");
			if(i < 0){
				i = sb.length();
			}
			
			server = sb.substring(0, i);
			sb.delete(0, i + 1);
		}
		
		String resource = "";
		if (sb.length() > 0) {
			resource = sb.toString();
		}
		
		System.out.printf("[protocol] = \"%s\"%n", protocol);
		System.out.printf("[server] = \"%s\"%n", server);
		System.out.printf("[resource] = \"%s\"%n", resource);
		
	}

}
