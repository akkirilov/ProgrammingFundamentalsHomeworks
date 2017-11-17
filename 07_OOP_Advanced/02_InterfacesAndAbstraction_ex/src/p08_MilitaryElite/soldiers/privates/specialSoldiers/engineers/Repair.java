package p08_MilitaryElite.soldiers.privates.specialSoldiers.engineers;

public class Repair implements RepairApi {
	
	private String partName;
	private int hoursWorked;
	
	public Repair(String partName, int hoursWorked) {
		super();
		this.partName = partName;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public String getPartName() {
		return partName;
	}

	@Override
	public int getHoursWorked() {
		return hoursWorked;
	}

	@Override
	public String toString() {
		return String.format("Part Name: %s Hours Worked: %d", partName, hoursWorked);
	}

}
