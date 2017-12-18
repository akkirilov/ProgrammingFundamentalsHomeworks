package p04_WorkForce.models;

public class PartTimeEmployee extends AbstractEmployee {

	private final static int HOURS_PER_WEEK = 20;
	
	public PartTimeEmployee(String name) {
		super(name);
	}

	@Override
	public int getWorkHoursPerWeek() {
		return HOURS_PER_WEEK;
	}

}
