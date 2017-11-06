package avatar.entities.benders;

public class FireBender extends Bender {
	
	private double heatAggression;

	public FireBender(String name, int power, double heatAggression) {
		super(name, power);
		setHeatAggression(heatAggression);
	}

	private void setHeatAggression(double heatAggression) {
		this.heatAggression = heatAggression;
	}

	private double getHeatAggression() {
		return heatAggression;
	}

	@Override
	public double getSecondaryParameter() {
		return this.getHeatAggression();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Fire Bender: ");
		sb.append(super.getName()).append(", Power: ").append(super.getPower())
		.append(", Heat Aggression: ").append(String.format("%.2f", this.getHeatAggression()));
		return sb.toString();
	}
	
}
