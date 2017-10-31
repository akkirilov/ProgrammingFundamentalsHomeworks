
public class Player {
	
	private static final int MIN_STAT_VALUE = 0;
	private static final int MAX_STAT_VALUE = 100;
	
	private String name;
	private int endurance; 
	private int sprint; 
	private int dribble; 
	private int passing; 
	private int shooting;
	
	public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
		super();
		setName(name);
		setEndurance(endurance);
		setSprint(sprint);
		setDribble(dribble);
		setPassing(passing);
		setShooting(shooting);
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

	private void setEndurance(int endurance) {
		if (endurance < MIN_STAT_VALUE || endurance > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("Endurance should be between 0 and 100.");
		}
		this.endurance = endurance;
	}

	private void setSprint(int sprint) {
		if (sprint < MIN_STAT_VALUE || sprint > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("Sprint should be between 0 and 100.");
		}
		this.sprint = sprint;
	}

	private void setDribble(int dribble) {
		if (dribble < MIN_STAT_VALUE || dribble > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("Dribble should be between 0 and 100.");
		}
		this.dribble = dribble;
	}

	private void setPassing(int passing) {
		if (passing < MIN_STAT_VALUE || passing > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("Passing should be between 0 and 100.");
		}
		this.passing = passing;
	}

	private void setShooting(int shooting) {
		if (shooting < MIN_STAT_VALUE || shooting > MAX_STAT_VALUE) {
			throw new IllegalArgumentException("Shooting should be between 0 and 100.");
		}
		this.shooting = shooting;
	} 

	public double getPlayerStats() {
		return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
	}
	
}
