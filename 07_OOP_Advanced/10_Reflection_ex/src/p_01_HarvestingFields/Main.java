package p_01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String command = scanner.nextLine();
			if (command.equalsIgnoreCase("HARVEST")) {
				break;
			}

			switch (command) {
			case "public":
				printAllPublicFields(fields);
				break;
			case "private":
				printAllPrivateFields(fields);
				break;
			case "protected":
				printAllProtectedFields(fields);
				break;
			case "all":
				printAllFields(fields);
				break;
			default:
				break;
			}
		}
		scanner.close();

	}

	private static void printAllProtectedFields(Field[] fields) {
		for (Field field : fields) {
			if (Modifier.isProtected(field.getModifiers())) {
				System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName());
			}
		}
	}

	private static void printAllPublicFields(Field[] fields) {
		for (Field field : fields) {
			if (Modifier.isPublic(field.getModifiers())) {
				System.out.println("public " + field.getType().getSimpleName() + " " + field.getName());
			}
		}
	}
	
	private static void printAllPrivateFields(Field[] fields) {
		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				System.out.println("private " + field.getType().getSimpleName() + " " + field.getName());
			}
		}
	}
	
	private static void printAllFields(Field[] fields) {
		for (Field field : fields) {
			if (Modifier.isPublic(field.getModifiers())) {
				System.out.println("public " + field.getType().getSimpleName() + " " + field.getName());
			} else if (Modifier.isPrivate(field.getModifiers())) {
				System.out.println("private " + field.getType().getSimpleName() + " " + field.getName());
			} else if (Modifier.isProtected(field.getModifiers())) {
				System.out.println("protected " + field.getType().getSimpleName() + " " + field.getName());
			}
		}
	}
	
}
