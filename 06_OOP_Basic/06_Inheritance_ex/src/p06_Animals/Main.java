package p06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Animal> animals = new ArrayList<>();
		
		String type = reader.readLine();
		while (!type.equals("Beast!")) {
			
			String[] tokens = reader.readLine().split("\\s+");
			try {
				animals.add(getAnimalFromTokens(type, tokens));			
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			
			type = reader.readLine();
		}
		
		reader.close();
		
		for (Animal a : animals) {
			System.out.println(a);
		}
		
	}

	private static Animal getAnimalFromTokens(String type, String[] tokens) {
		String name = tokens[0];
		String gender = tokens[2];
		int age = Integer.parseInt(tokens[1]);
		switch (type) {
		case "Dog":
			return new Dog(name, gender, age);
		case "Frog":
			return new Frog(name, gender, age);
		case "Cat":
			return new Cat(name, gender, age);
		case "Kitten":
			return new Kitten(name, gender, age);
		case "Tomcat":
			return new Tomcat(name, gender, age);
		default:
			throw new IllegalArgumentException("Invalid input!");
		}
	}

}
