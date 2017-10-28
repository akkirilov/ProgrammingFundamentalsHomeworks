import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private Company company;
	private Car car;
	private List<Parent> parents;
	private List<Child> children;
	private List<Pokemon> pokemons;
	
	public Person(String name) {
		super();
		this.name = name;
		this.parents = new ArrayList<>();
		this.children = new ArrayList<>();
		this.pokemons = new ArrayList<>();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void addParent(Parent parent) {
		this.parents.add(parent);
	}

	public List<Child> getChildren() {
		return children;
	}

	public void addChild(Child child) {
		this.children.add(child);
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void addPokemon(Pokemon pokemon) {
		this.pokemons.add(pokemon);
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.name + "%nCompany:%n");
		if (this.company != null) {
			sb.append(company + "%n");
		}
		sb.append("Car:%n");
		if (this.car != null) {
			sb.append(car + "%n");
		}
		sb.append("Pokemon:%n");
		if (this.pokemons.size() > 0) {
			sb.append(pokemons.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\r\n") + "%n");
		}
		sb.append("Parents:%n");
		if (this.parents.size() > 0) {
			sb.append(parents.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\r\n") + "%n");
		}
		sb.append("Children:%n");
		if (this.children.size() > 0) {
			sb.append(children.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\r\n") + "%n");
		}
		return String.format(sb.toString());
	}
	
}
