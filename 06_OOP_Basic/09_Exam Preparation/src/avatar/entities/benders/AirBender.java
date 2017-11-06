package avatar.entities.benders;

public class AirBender extends Bender {
	
	private double aerialIntegrity;

	public AirBender(String name, int power, double aerialIntegrity) {
		super(name, power);
		setAerialIntegrity(aerialIntegrity);
	}

	private void setAerialIntegrity(double aerialIntegrity) {
		this.aerialIntegrity = aerialIntegrity;
	}

	private double getAerialIntegrity() {
		return aerialIntegrity;
	}

	@Override
	public double getSecondaryParameter() {
		return this.getAerialIntegrity();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Air Bender: ");
		sb.append(super.getName()).append(", Power: ").append(super.getPower())
		.append(", Aerial Integrity: ").append(String.format("%.2f", this.getAerialIntegrity()));
		return sb.toString();
	}

}
