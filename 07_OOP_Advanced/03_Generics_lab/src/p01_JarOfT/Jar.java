package p01_JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
	
	private ArrayDeque<T> jar;

	public Jar() {
		this.jar = new ArrayDeque<>();
	}
	
	public void add(T item){
		this.jar.addLast(item);
	}
	
	public T remove() {
		return this.jar.removeLast();
	}

}
