import java.util.ArrayList;
import java.util.List;

public class Trainer {
	
	private String name;
	private int badges;
	List<Pokemon> pokemons;
	
	public Trainer(String name) {
		super();
		this.name = name;
		this.badges = 0;
		this.pokemons = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public int getBadges() {
		return badges;
	}
	
	public void addBadge() {
		this.badges++;
	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public void addPokemon(Pokemon pokemon) {
		this.pokemons.add(pokemon);
	}
	
	public boolean hasAtLeastOneWithElement(String element) {
		boolean res = false;
		for (Pokemon p : this.pokemons) {
			if (p.getElement().equals(element)) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public void getTenFromAllPokemons() {
		for (int i = 0; i < pokemons.size(); i++) {
			pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
			if (pokemons.get(i).getHealth() <= 0) {
				pokemons.remove(i);
				i--;
			}
		}
	}

	public void winOneBadge () {
		this.badges++;
	}

	@Override
	public String toString() {
		return String.format("%s %d %d", this.name, this.badges, this.getPokemons().size());
	}
	
	
	
}
