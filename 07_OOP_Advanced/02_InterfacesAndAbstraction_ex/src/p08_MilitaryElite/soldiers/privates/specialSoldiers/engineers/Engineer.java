package p08_MilitaryElite.soldiers.privates.specialSoldiers.engineers;

import java.util.List;

import p08_MilitaryElite.soldiers.privates.specialSoldiers.SpecialisedSoldier;

public class Engineer extends SpecialisedSoldier implements EngineerApi {

	private List<Repair> repairs;

	public Engineer(String id, String firstName, String lastName, double salary, String corp, List<Repair> repairs) {
		super(id, firstName, lastName, salary, corp);
		this.repairs = repairs;
	}
	
	@Override
	public String getRepairs() {
		StringBuilder sb = new StringBuilder("\r\n");
		for (Repair r : repairs) {
			sb.append("  ").append(r.toString()).append("\r\n");
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return String.format("%s"
				+ "Repairs:%s", 
				super.toString(),
				this.getRepairs());
	}
	
}
