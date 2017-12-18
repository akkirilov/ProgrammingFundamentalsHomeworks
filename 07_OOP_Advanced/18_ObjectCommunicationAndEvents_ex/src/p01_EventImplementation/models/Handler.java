package p01_EventImplementation.models;

import p01_EventImplementation.contracts.NameChangeListener;

public class Handler implements NameChangeListener {
	
	@Override
	public void handleChangedName(NameChange event) {
		System.out.println("Dispatcher's name changed to " + event.getChangedName() + ".");
	}

}
