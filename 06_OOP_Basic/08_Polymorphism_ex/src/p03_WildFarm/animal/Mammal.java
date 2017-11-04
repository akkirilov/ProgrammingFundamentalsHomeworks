package p03_WildFarm.animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

	protected final DecimalFormat PRINT_DISTANCE_FORMAT = new DecimalFormat("#.##");
	
	private String livingRegion;
	
	public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight);
		setLivingRegion(livingRegion);
	}

	protected String getLivingRegion() {
		return livingRegion;
	}

	protected void setLivingRegion(String livingRegion) {
		this.livingRegion = livingRegion;
	}

	@Override
	public String toString() {
		return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.PRINT_DISTANCE_FORMAT.format(getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
	}

}
