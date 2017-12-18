package p04_WorkForce.contracts;

import p04_WorkForce.events.EventType;

public interface Handler {
	
	void handle(EventType eventType, Job job);

}
