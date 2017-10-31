import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Team> teams = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = reader.readLine().split(";");
		while (!tokens[0].equals("END")) {
			switch (tokens[0]) {
			case "Team":
				addTeam(tokens);
				break;
			case "Add":
				addPlayer(tokens);
				break;
			case "Remove":
				removePlayer(tokens);
				break;
			case "Rating":
				printRating(tokens[1]);
				break;
			default:
				break;
			}
			
			tokens = reader.readLine().split(";");
		}
	}

	private static void printRating(String teamName) {
		if (!teamExists(teamName)) {
			System.out.println("Team " + teamName + " does not exist.");
		} else {
			for (Team t : teams) {
				if (t.getName().equals(teamName)) {
					System.out.println(t.getName() + " - " + (int) Math.round(t.getStats()));
					break;
				}
			}
		}
		
	}

	private static void removePlayer(String[] tokens) {
		
		if (!teamExists(tokens[1])) {
			System.out.println("Team " + tokens[1] + " does not exist.");
		} else if (!teamContainsPlayer(tokens[1], tokens[2])) {
			System.out.println("Player " + tokens[2] + " is not in " + tokens[1] + " team.");
		} else {
			for (int i = 0; i < teams.size(); i++) {
				if (teams.get(i).getName().equals(tokens[1])) {
					teams.get(i).removePlayer(tokens[2]);
					break;
				}
			}
		}
		
	}

	private static boolean teamContainsPlayer(String teamName, String playerName) {
		for (Team t : teams) {
			if (t.getName().equals(teamName) && t.containsPlayer(playerName)) {
				return true;
			}
		}
		return false;
	}

	private static void addPlayer(String[] tokens) {
		
		if (!teamExists(tokens[1])) {
			System.out.println("Team " + tokens[1] + " does not exist.");
			return;
		}
		
		try {
			Player player = new Player(tokens[2], Integer.parseInt(tokens[3]), 
					Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),
					Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
			for (int i = 0; i < teams.size(); i++) {
				if (teams.get(i).getName().equals(tokens[1])) {
					teams.get(i).addPlayer(player);
					break;
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static boolean teamExists(String name) {
		for (Team t : teams) {
			if (t.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private static void addTeam(String[] tokens) {
		try {
			teams.add(new Team(tokens[1]));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
