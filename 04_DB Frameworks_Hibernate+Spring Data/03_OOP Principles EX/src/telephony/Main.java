package telephony;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] calls = scanner.nextLine().split("\\s+");
		String[] browsers = scanner.nextLine().split("\\s+");
		scanner.close();

		for (int i = 0; i < calls.length; i++) {
			if (isValidNumber(calls[i])) {
				SmartPhone temp = new SmartPhone(calls[i]);
				System.out.println(temp.calling());
			}
		}

		for (int i = 0; i < browsers.length; i++) {
			if (isValidWeb(browsers[i])) {
				SmartPhone temp = new SmartPhone(browsers[i]);
				System.out.println(temp.browsing());
			}
		}

	}

	private static boolean isValidWeb(String browse) {
		for (int i = 0; i < browse.length(); i++) {
			if (Character.isDigit(browse.charAt(i))) {
				System.out.println("Invalid URL!");
				return false;
			}
		}
		return true;
	}

	private static boolean isValidNumber(String call) {
		for (int i = 0; i < call.length(); i++) {
			if (!Character.isDigit(call.charAt(i))) {
				System.out.println("Invalid number!");
				return false;
			}
		}
		return true;
	}

}
