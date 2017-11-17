package p08_MilitaryElite.soldiers.privates.specialSoldiers.commandos;

public class Mission implements MissionApi {

	private String codeName;
	private String state;
	
	public Mission(String codeName, String state) {
		this.codeName = codeName;
		this.state = state;
	}
	
	@Override
	public String getCodeName() {
		return codeName;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void completeMission() {
		this.state = "Finished";
	}

	@Override
	public String toString() {
		return String.format("Code Name: %s State: %s", this.codeName, this.state);
	}
	
}
