package p11_Treeuple;

public class Treeuple <F, S, T> {

	private F itemOne;
	private S itemTwo;
	private T itemThree;
	
	public Treeuple(F itemOne, S itemTwo, T itemThree) {
		this.itemOne = itemOne;
		this.itemTwo = itemTwo;
		this.itemThree = itemThree;
	}

	public F getItemOne() {
		return this.itemOne;
	}

	public S getItemTwo() {
		return this.itemTwo;
	}

	public T getItemThree() {
		return this.itemThree;
	}

	@Override
	public String toString() {
		return this.itemOne + " -> " + this.itemTwo + " -> " + this.itemThree;
	}
	
}
