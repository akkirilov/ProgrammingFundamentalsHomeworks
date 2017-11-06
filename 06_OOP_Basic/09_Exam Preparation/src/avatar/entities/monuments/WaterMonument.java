package avatar.entities.monuments;

public class WaterMonument extends Monument {
	
	private int waterAffinity;

	public WaterMonument(String name, int waterAffinity) {
		super(name);
		setWaterAffinity(waterAffinity);
	}

	private int getWaterAffinity() {
		return waterAffinity;
	}

	private void setWaterAffinity(int waterAffinity) {
		this.waterAffinity  = waterAffinity ;
	}

	@Override
	public int getAffinity() {
		return this.getWaterAffinity();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Water Monument: ");
		sb.append(super.getName()).append(", Water Affinity: ").append(this.getWaterAffinity());
		return sb.toString();
	}
	
}
