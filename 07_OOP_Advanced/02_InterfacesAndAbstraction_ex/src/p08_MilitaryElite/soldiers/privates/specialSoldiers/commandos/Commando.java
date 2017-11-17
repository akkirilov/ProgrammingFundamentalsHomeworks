package p08_MilitaryElite.soldiers.privates.specialSoldiers.commandos;

import java.util.List;

import p08_MilitaryElite.soldiers.privates.specialSoldiers.SpecialisedSoldier;

public class Commando extends SpecialisedSoldier implements CommandoApi {

	private List<Mission> missions;

	public Commando(String id, String firstName, String lastName, double salary, String corp, List<Mission> missions) {
		super(id, firstName, lastName, salary, corp);
		this.missions = missions;
	}

	@Override
	public String getMissions() {
		StringBuilder sb = new StringBuilder("\r\n");
		for (Mission m : missions) {
			sb.append("  ").append(m.toString()).append("\r\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return String.format("%s"
				+ "Missions:%s", 
				super.toString(),
				this.getMissions());
	}

}
