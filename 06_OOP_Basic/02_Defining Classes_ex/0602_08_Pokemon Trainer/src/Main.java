import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Trainer> trainers = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(isr);

	    Pokemon tempPokemon;
	    Trainer tempTrainer = null;
	    boolean found;
	    String trainerName;
	    String pokemonName;
	    String element;
	    int health;
	    String[] tokens = reader.readLine().split("\\s+");
	    while (!tokens[0].equals("Tournament")) {
	    	found = false;
	    	trainerName = tokens[0];
	    	pokemonName = tokens[1];
	    	element = tokens[2];
	    	health = Integer.parseInt(tokens[3]);
	    	
	    	tempPokemon = new Pokemon(pokemonName, element, health);
	    	
	    	for (Trainer t : trainers) {
				if (t.getName().equals(trainerName)) {
					t.addPokemon(tempPokemon);
					found = true;
					break;
				}
				
			}
	    	
	    	if (!found) {
	    		tempTrainer = new Trainer(trainerName);
	    		tempTrainer.addPokemon(tempPokemon);
	    		trainers.add(tempTrainer);
			}
	    	
	    	tokens = reader.readLine().split("\\s+");
		}

	    String command = reader.readLine().trim();
	    while (!command.equals("End")) {
	    	element = command;
	    	
	    	fight(element);
	    	
	    	command = reader.readLine().trim();
		}
	    
	    reader.close();
	    
	    printTrainers();
	    
	}

	private static void printTrainers() {
		trainers.stream()
				.sorted((a, b) -> Integer.compare(b.getBadges(), a.getBadges()))
				.forEach(x -> System.out.println(x));
	}

	private static void fight(String element) {
		for (Trainer t : trainers) {
			if (t.hasAtLeastOneWithElement(element)) {
				t.winOneBadge();
			} else {
				t.getTenFromAllPokemons();
			}
		}
	}

}
