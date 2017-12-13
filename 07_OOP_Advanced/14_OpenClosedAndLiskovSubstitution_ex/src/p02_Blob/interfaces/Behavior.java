package p02_Blob.interfaces;

import p02_Blob.models.Blob;

public interface Behavior {
	
	boolean isTriggered();
	
	void triggerBehavior(Blob source);
	
	void takeTriggerEffect(Blob source);
	
}
