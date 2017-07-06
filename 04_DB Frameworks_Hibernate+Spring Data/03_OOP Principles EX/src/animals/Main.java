package animals;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			String type = scanner.nextLine();
			String[] input;
			
			Animal animal;
			while (!type.equals("Beast!")) {
				input = scanner.nextLine().split("\\s+");
				String name = input[0];
				Integer age = Integer.parseInt(input[1]);
				String gender = input[2];
				try {
					animal = null;
					if (type.toLowerCase().trim().equals("cat")) {
						animal = new Cat(name, age, gender);
					} else if (type.toLowerCase().trim().equals("dog")) {
						animal = new Dog(name, age, gender);
					} else if (type.toLowerCase().trim().equals("frog")) {
						animal = new Frog(name, age, gender);
					} else if (type.toLowerCase().trim().equals("kitten")) {
						animal = new Kitten(name, age);
					} else if (type.toLowerCase().trim().equals("tomcat")) {
						animal = new Tomcat(name, age);
					} else {
						throw new IllegalArgumentException("Invalid input!");
					}
	                
					System.out.print(animal.toString());
					animal.produceSound();
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			type = scanner.nextLine();
		}
		scanner.close();
	}

}
