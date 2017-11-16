package p03_Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

import p03_Ferrari.cars.*;

public class Main {

	public static void main(String[] args) throws IllegalClassFormatException {
		
		Scanner scanner = new Scanner(System.in);
		String driver = scanner.nextLine();
		Ferrari ferrari = new Ferrari(driver);
		scanner.close();
		
		System.out.println(ferrari);
		
		String ferrariName = Ferrari.class.getSimpleName();
		String carInterface = Car.class.getSimpleName();
		boolean isCreated = Car.class.isInterface();
		if (!isCreated) {
		    throw new IllegalClassFormatException("No interface created!");
		}


	}

}
