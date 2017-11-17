package p10_MooD3.gameObjects;

public abstract class GameObjectBase implements GameObject {
	
	private String username;
	private String hashedPassword;
	private String specialPoints;
	private int level;
	
	protected GameObjectBase(String username, int level) {
		setUsername(username);
		setLevel(level);
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	protected void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	protected void setSpecialPoints(String specialPoints) {
		this.specialPoints = specialPoints;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public int getLevel() {
		return this.level;
	}
	
	@Override
	public String getHashedPassword() {
		return this.hashedPassword;
	}

	@Override
	public String getSpecialPoints() {
		return this.specialPoints;
	}
	
	@Override
	public String toString() {
		return String.format("\"%s\" | \"%s\" -> %s%n"
				+ "%s", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName(),
				this.getSpecialPoints());
	}

}
