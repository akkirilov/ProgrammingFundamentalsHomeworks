package p02_KingsGambit.models;

import java.util.ArrayList;
import java.util.List;

import p02_KingsGambit.contracts.Attackable;
import p02_KingsGambit.contracts.Observer;

public class King extends AbstractUnit implements Attackable {

	private List<Observer> observers;
	
	public King(String name) {
		super(name);
		this.observers = new ArrayList<>();
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyAllObservers() {
		for (Observer o : this.observers) {
			o.update();
		}
	}

	@Override
	public void respondToAttack() {
		System.out.println(String.format("King %s is under attack!", super.getName()));
		this.notifyAllObservers();
	}

}
