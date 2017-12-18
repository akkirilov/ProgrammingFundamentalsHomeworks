package p01_EventImplementation;

import java.util.Scanner;

import p01_EventImplementation.contracts.NameChangeListener;
import p01_EventImplementation.models.Dispatcher;
import p01_EventImplementation.models.Handler;
import p01_EventImplementation.models.NameChange;

public class Main {

	public static void main(String[] args) {

		NameChangeListener handler = new Handler();
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.addNameChangeListener(handler);
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("end")) {
				break;
			}
			dispatcher.changeName(new NameChange(line));
		}
		scanner.close();

	}

}
