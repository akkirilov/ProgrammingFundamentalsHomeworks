package p06_GenericCountMethodDouble;

public class Box <T> {

	private T item;

	public Box(T item) {
		this.item = item;
	}
	
	public T get() {
		return item;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", item.getClass().getName(), item);
	}
	
}
