package p04_WorkForce.events;

import p04_WorkForce.contracts.Event;
import p04_WorkForce.contracts.Job;

public class JobDoneEvent implements Event {

	@Override
	public void activateEvent(Job job) {
		System.out.println(String.format("Job %s done!", job.getName()));
	}
	
}
