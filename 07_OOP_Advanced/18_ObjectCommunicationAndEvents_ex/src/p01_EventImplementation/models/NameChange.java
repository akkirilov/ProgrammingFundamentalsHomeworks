package p01_EventImplementation.models;

import p01_EventImplementation.contracts.Event;

public class NameChange implements Event {

	private String changedName;

	public NameChange(String changedName) {
		this.changedName = changedName;
	}

	public String getChangedName() {
		return this.changedName;
	}
	
}
