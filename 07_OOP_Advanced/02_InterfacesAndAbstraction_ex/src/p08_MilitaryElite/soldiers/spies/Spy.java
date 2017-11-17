package p08_MilitaryElite.soldiers.spies;

import p08_MilitaryElite.soldiers.Soldier;

public class Spy extends Soldier implements SpyApi {

	private String codeNumber;

	public Spy(String id, String firstName, String lastName, String codeNumber) {
		super(id, firstName, lastName);
		this.codeNumber = codeNumber;
	}

	@Override
	public String getCodeNumber() {
		return codeNumber;
	}

	@Override
	public String toString() {
		return String.format("%s%nCode Number: %s%n", 
				super.toString(),
				this.codeNumber);
		}
	
}
