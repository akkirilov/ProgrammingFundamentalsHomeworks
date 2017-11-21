package p10_Tuple;

public class Tuple <T, E> {

	private T itemOne;
	private E itemTwo;
	
	public Tuple(T itemOne, E itemTwo) {
		this.itemOne = itemOne;
		this.itemTwo = itemTwo;
	}

	public T getItemOne() {
		return itemOne;
	}

	public E getItemTwo() {
		return itemTwo;
	}

	@Override
	public String toString() {
		return itemOne + " -> " + itemTwo;
	}
	
}
