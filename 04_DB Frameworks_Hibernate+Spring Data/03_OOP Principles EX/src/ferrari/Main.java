package ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalClassFormatException {
		Scanner scanner = new Scanner(System.in);
		String driverName = scanner.nextLine();
		scanner.close();

		Ferrari ferrari = new Ferrari(driverName);
		ferrari.print();

		String ferrariName = Ferrari.class.getSimpleName();
		String carInterface = Car.class.getSimpleName();

		boolean isCreated = Car.class.isInterface();
		if (!isCreated) {
			throw new IllegalClassFormatException("No interface created!");
		}

	}

}
