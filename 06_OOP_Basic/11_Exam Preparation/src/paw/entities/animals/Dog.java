package paw.entities.animals;

public class Dog extends Animal {
	
	private int learnedCommands;

	public Dog(String name, int age, int learnedCommands) {
		super(name, age);
		setLearnedCommands(learnedCommands);
	}

	public int getLearnedCommands() {
		return learnedCommands;
	}

	private void setLearnedCommands(int learnedCommands) {
		this.learnedCommands = learnedCommands;
	}

	@Override
	public String toString() {
		return super.getName();
	}
}
