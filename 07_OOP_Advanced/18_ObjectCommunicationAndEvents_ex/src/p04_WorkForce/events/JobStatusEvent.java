package p04_WorkForce.events;

import p04_WorkForce.contracts.Event;
import p04_WorkForce.contracts.Job;

public class JobStatusEvent implements Event {

	@Override
	public void activateEvent(Job job) {
		System.out.println(String.format("Job: %s Hours Remaining: %d", job.getName(), job.getRemainingHours()));
	}
	
}
