import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private String name;
	private List<Player> players;
	
	public Team(String name) {
		super();
		setName(name);
		this.players = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		if (name == null || name.isEmpty() || name.equals(" ")) {
			throw new IllegalArgumentException("A name should not be empty.");
		}
		this.name = name;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public void removePlayer(String name) {
		boolean found = false;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(name)) {
				players.remove(i);
				found = true;
				break;
			}
		}
		if (!found) {
			throw new IllegalArgumentException("Player + " + name + " is not in " + this.name + " team.");
		}
	}

	public boolean containsPlayer(String playerName) {
		for (Player p : players) {
			if (p.getName().equals(playerName)) {
				return true;
			}
		}
		return false;
	}

	public double getStats() {
		if (this.players.size() == 0) {
			return 0;
		}
		
		double res = 0;
		for (Player p : players) {
			res += p.getPlayerStats();
		}
		return res / players.size();
	}
	
}
