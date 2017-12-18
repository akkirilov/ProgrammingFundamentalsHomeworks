package p01_EventImplementation.contracts;

import p01_EventImplementation.models.NameChange;

public interface NameChangeListener {

	void handleChangedName(NameChange event);
	
}
