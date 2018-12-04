import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
	private String name;
	private Map<String, Integer> contests;

	public User(String name) {
		super();
		this.setName(name);
		this.contests = new LinkedHashMap<>();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Integer getPoints() {
		Integer points = 0;
		for (Map.Entry<String, Integer> e : this.contests.entrySet()) {
			points += e.getValue();
		}
		return points;
	}

	public void printContests() {
		for (Map.Entry<String, Integer> e : this.contests.entrySet()) {
			System.out.println("#  " + e.getKey() + " -> " + e.getValue());
		}
	}

	public void sortContests() {
		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(this.contests.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
				return b.getValue().compareTo(a.getValue());
			}
		});

		this.contests = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : entries) {
			this.contests.put(entry.getKey(), entry.getValue());
		}
	}

	public void addContest(String contest, Integer points) {
		this.contests.put(contest, points);
	}

	public void addPoints(String contest, Integer points) {
		this.contests.put(contest, points);
	}

	public Map<String, Integer> getContests() {
		return this.contests;
	}

	public Boolean hasContest(String contest) {
		for (Map.Entry<String, Integer> e : this.contests.entrySet()) {
			if (e.getKey().equals(contest)) {
				return true;
			}
		}
		return false;
	}

	public Integer getContestPoints(String contest) {
		return this.contests.get(contest);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
