package p04_WorkForce.events;

import p04_WorkForce.contracts.Event;
import p04_WorkForce.contracts.Handler;
import p04_WorkForce.contracts.Job;

public class EventHandler implements Handler {

	private static Event jobDoneEvent = new JobDoneEvent();
	private static Event jobStatusEvent = new JobStatusEvent();
	
	@Override
	public void handle(EventType eventType, Job job) {
		if (eventType == EventType.DONE) {
			jobDoneEvent.activateEvent(job);
		} else if (eventType == EventType.STATUS) {
			jobStatusEvent.activateEvent(job);
		}
	}

}
