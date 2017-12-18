package p04_WorkForce.models;

import p04_WorkForce.contracts.Employee;
import p04_WorkForce.contracts.Job;
import p04_WorkForce.events.EventType;

public class JobImpl implements Job {
	
	private String name;
	private int hoursToDone;
	private Employee employee;
	
	public JobImpl(String name, int hoursToDone, Employee employee) {
		this.name = name;
		this.hoursToDone = hoursToDone;
		this.employee = employee;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getRemainingHours() {
		return this.hoursToDone;
	}
	
	@Override
	public EventType update() {
		this.hoursToDone -= this.employee.getWorkHoursPerWeek();
		if (this.hoursToDone <= 0) {
			return EventType.DONE;
		} else {
			return EventType.UNDONE;
		}
	}

}
