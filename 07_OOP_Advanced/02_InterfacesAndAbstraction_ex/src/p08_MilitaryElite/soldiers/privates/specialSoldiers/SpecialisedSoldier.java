package p08_MilitaryElite.soldiers.privates.specialSoldiers;

import p08_MilitaryElite.soldiers.privates.Private;

public abstract class SpecialisedSoldier extends Private implements SpecialisedSoldierApi {
	
	private String corp;

	protected SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corp) {
		super(id, firstName, lastName, salary);
		this.corp = corp;
	}

	@Override
	public String getCorp() {
		return corp;
	}

	@Override
	public String toString() {
		return String.format("%s"
				+ "Corps: %s%n", 
				super.toString(),
				this.corp);
	}
	
}
