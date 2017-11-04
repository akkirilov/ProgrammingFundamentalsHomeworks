package p03_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import p03_WildFarm.animal.Animal;
import p03_WildFarm.exceptions.FoodException;
import p03_WildFarm.factories.*;
import p03_WildFarm.food.Food;

public class Main {

	public static void main(String[] args) throws IOException {
List<Animal> animals = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = reader.readLine().split("\\s+");
		while (!tokens[0].toLowerCase().equals("end")) {
			
			Animal tempAnimal = AnimalFactory.create(tokens);
			System.out.println(tempAnimal.makeSound());
			
			tokens = reader.readLine().split("\\s+");
			Food tempFood = FoodFactory.create(tokens);
			
			try {
				tempAnimal.eat(tempFood);
			} catch (FoodException e) {
				System.out.println(e.getMessage());
			}
			animals.add(tempAnimal);
			
			tokens = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		for (Animal a : animals) {
			System.out.println(a);
		}

	}

}
