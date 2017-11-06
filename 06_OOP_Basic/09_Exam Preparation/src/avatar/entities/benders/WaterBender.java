package avatar.entities.benders;

public class WaterBender extends Bender {
	
	private double waterClarity;

	public WaterBender(String name, int power, double waterClarity) {
		super(name, power);
		setWaterClarity(waterClarity);
	}

	private void setWaterClarity(double waterClarity) {
		this.waterClarity = waterClarity;
	}

	private double getWaterClarity() {
		return waterClarity;
	}

	@Override
	public double getSecondaryParameter() {
		return this.getWaterClarity();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Water Bender: ");
		sb.append(super.getName()).append(", Power: ").append(super.getPower())
		.append(", Water Clarity: ").append(String.format("%.2f", this.getWaterClarity()));
		return sb.toString();
	}
	
}
