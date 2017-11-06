package avatar.entities.benders;

public abstract class Bender {

	private String name;
	private int power;
	
	public Bender(String name, int power) {
		setName(name);
		setPower(power);
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getPower() {
		return power;
	}
	
	private void setPower(int power) {
		this.power = power;
	}
	
	public abstract double getSecondaryParameter();
		
}
