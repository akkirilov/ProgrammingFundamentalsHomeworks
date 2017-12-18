package p02_KingsGambit.contracts;

public interface Subject {
	
	void addObserver(Observer observer);
	
	void removeObserver(Observer observer);
	
	void notifyAllObservers();
	

}
