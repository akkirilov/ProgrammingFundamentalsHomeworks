package paw.entities.animals;

public class Cat extends Animal {
	
	private int intelligenceCoefficient;

	public Cat(String name, int age, int intelligenceCoefficient) {
		super(name, age);
		setIntelligenceCoefficient(intelligenceCoefficient);
	}

	public int getIntelligenceCoefficient() {
		return intelligenceCoefficient;
	}

	private void setIntelligenceCoefficient(int intelligenceCoefficient) {
		this.intelligenceCoefficient = intelligenceCoefficient;
	}

	@Override
	public String toString() {
		return super.getName();
	}
}
