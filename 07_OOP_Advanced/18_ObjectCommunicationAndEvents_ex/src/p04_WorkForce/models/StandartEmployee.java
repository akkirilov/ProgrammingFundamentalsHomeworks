package p04_WorkForce.models;

public class StandartEmployee extends AbstractEmployee {

	private final static int HOURS_PER_WEEK = 40;
	
	public StandartEmployee(String name) {
		super(name);
	}

	@Override
	public int getWorkHoursPerWeek() {
		return HOURS_PER_WEEK;
	}

}
