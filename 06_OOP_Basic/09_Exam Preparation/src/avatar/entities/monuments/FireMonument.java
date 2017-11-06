package avatar.entities.monuments;

public class FireMonument extends Monument {
	
	private int fireAffinity;

	public FireMonument(String name, int fireAffinity) {
		super(name);
		setFireAffinity(fireAffinity);
	}

	private int getFireAffinity() {
		return fireAffinity;
	}

	private void setFireAffinity(int fireAffinity) {
		this.fireAffinity  = fireAffinity;
	}

	@Override
	public int getAffinity() {
		return this.getFireAffinity();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Fire Monument: ");
		sb.append(super.getName()).append(", Fire Affinity: ").append(this.getFireAffinity());
		return sb.toString();
	}
	
}
