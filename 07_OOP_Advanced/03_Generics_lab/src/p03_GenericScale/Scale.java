package p03_GenericScale;

public class Scale<T extends Comparable<T>> {

	private T elementOne;
	private T elementTwo;
	
	public Scale(T elementOne, T elementTwo) {
		super();
		this.elementOne = elementOne;
		this.elementTwo = elementTwo;
	}
	
	public T getHeavier() {
		int res = elementTwo.compareTo(elementOne);
		if (res > 0) {
			return elementTwo;
		} else if (res < 0) {
			return elementOne;
		} else {
			return null;
		}
	}
	
}
