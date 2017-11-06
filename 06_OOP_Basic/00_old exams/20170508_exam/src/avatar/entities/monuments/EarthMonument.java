package avatar.entities.monuments;

public class EarthMonument extends Monument {
	
	private int earthAffinity;

	public EarthMonument(String name, int earthAffinity) {
		super(name);
		setEarthAffinity(earthAffinity);
	}

	private int getEarthAffinity() {
		return earthAffinity;
	}

	private void setEarthAffinity(int earthAffinity) {
		this.earthAffinity  = earthAffinity ;
	}

	@Override
	public int getAffinity() {
		return this.getEarthAffinity();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Earth Monument: ");
		sb.append(super.getName()).append(", Earth Affinity: ").append(this.getEarthAffinity());
		return sb.toString();
	}
	
}
