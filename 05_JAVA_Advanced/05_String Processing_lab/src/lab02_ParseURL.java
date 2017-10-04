import java.util.Scanner;

public class lab02_ParseURL {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String url = scanner.nextLine();
		scanner.close();

		Integer endIndex = url.indexOf("://");
		if (endIndex < 0) {
			getInvalidMessage();
			return;
		}
		String protocol = url.substring(0, endIndex);
		url = url.substring(endIndex + 3, url.length());
		
		endIndex = url.indexOf("/");
		String server = url.substring(0, endIndex);
		if (endIndex < 0 || isContainsProtocol(url)) {
			getInvalidMessage();
			return;
		}
		
		String resources = url.substring(endIndex + 1, url.length());
		if (resources == null || isContainsProtocol(url)) {
			getInvalidMessage();
			return;
		}
		
		System.out.printf("Protocol = %s%nServer = %s%nResources = %s%n", protocol, server, resources);
		
	}

	private static void getInvalidMessage() {
		System.out.println("Invalid URL");
	}

	private static boolean isContainsProtocol(String url) {
		return url.indexOf("://") < 0 ? false : true;
	}

}
