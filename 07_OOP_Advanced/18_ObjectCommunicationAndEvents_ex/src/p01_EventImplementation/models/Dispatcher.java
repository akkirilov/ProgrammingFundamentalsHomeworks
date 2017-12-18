package p01_EventImplementation.models;

import java.util.ArrayList;
import java.util.List;

import p01_EventImplementation.contracts.NameChangeListener;

public class Dispatcher {

	private String name;
	private List<NameChangeListener> listeners;

	public Dispatcher() {
		this.name = "defaultName";
		this.listeners = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void changeName(NameChange event) {
		this.name = event.getChangedName();
		this.fireNameChangeEvent(event);
	}

	public void addNameChangeListener(NameChangeListener listener) {
		this.listeners.add(listener);
	}

	public void removeNameChangeListener(NameChangeListener listener) {
		this.listeners.remove(listener);
	}

	public void fireNameChangeEvent(NameChange event) {
		for (NameChangeListener l : listeners) {
			l.handleChangedName(event);
		}
	}

}
