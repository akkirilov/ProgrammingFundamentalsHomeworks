package avatar.entities.monuments;

public class AirMonument extends Monument {
	
	private int airAffinity;

	public AirMonument(String name, int airAffinity) {
		super(name);
		setAirAffinity(airAffinity);
	}

	private int getAirAffinity() {
		return airAffinity;
	}

	private void setAirAffinity(int airAffinity) {
		this.airAffinity  = airAffinity;
	}

	@Override
	public int getAffinity() {
		return this.getAirAffinity();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Air Monument: ");
		sb.append(super.getName()).append(", Air Affinity: ").append(this.getAirAffinity());
		return sb.toString();
	}

}
