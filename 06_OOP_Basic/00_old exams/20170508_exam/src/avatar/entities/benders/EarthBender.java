package avatar.entities.benders;

public class EarthBender extends Bender {
	
	private double groundSaturation;

	public EarthBender(String name, int power, double groundSaturation) {
		super(name, power);
		setGroundSaturation(groundSaturation);
	}

	private void setGroundSaturation(double groundSaturation) {
		this.groundSaturation = groundSaturation;
	}

	private double getGroundSaturation() {
		return groundSaturation;
	}

	@Override
	public double getSecondaryParameter() {
		return this.getGroundSaturation();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Earth Bender: ");
		sb.append(super.getName()).append(", Power: ").append(super.getPower())
		.append(", Ground Saturation: ").append(String.format("%.2f", this.getGroundSaturation()));
		return sb.toString();
	}

}
