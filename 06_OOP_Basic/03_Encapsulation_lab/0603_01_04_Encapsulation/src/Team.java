import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
	
	private List<Person> firstTeam;
	private List<Person> reserveTeam;
	
	public Team() {
		super();
		this.firstTeam = new ArrayList<>();
		this.reserveTeam = new ArrayList<>();
	}
	
	public List<Person> getFirstTeam() {
		return Collections.unmodifiableList(this.firstTeam);
	}

	public List<Person> getReserveTeam() {
		return Collections.unmodifiableList(this.reserveTeam);
	}

	public void addPlayer(Person person) {
		if (person.getAge() < 40) {
			firstTeam.add(person);
		} else {
			reserveTeam.add(person);
		}
	}

}
