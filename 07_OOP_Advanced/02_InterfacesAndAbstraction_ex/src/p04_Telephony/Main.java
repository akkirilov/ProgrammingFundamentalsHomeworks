package p04_Telephony;

import java.util.Scanner;

import p04_Telephony.smartphones.SmartPhone;

public class Main {

	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone();
		
		Scanner scanner = new Scanner(System.in);
		
		String[] numbers = scanner.nextLine().split("\\s+");
		String[] sites = scanner.nextLine().split("\\s+");

		for (String t : numbers) {
			try {
				phone.callNumber(t);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		
		for (String t : sites) {
			try {
				phone.browseSite(t);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		
		scanner.close();

	}

}
