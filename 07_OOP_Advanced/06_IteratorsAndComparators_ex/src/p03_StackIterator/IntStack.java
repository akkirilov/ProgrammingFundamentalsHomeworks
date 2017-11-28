package p03_StackIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class IntStack implements Iterable<Integer> {
	
	private List<Integer> intStack;

	public IntStack(Integer... ints){
		this.setIntStack(ints);
	}

	private void setIntStack(Integer... ints){
		intStack = new Stack<>();
		this.push(ints);
	}

	public void push(Integer... nums) {
		for (int i = 0; i < nums.length; i++){
			this.intStack.add(0, nums[i]);
		}
	}
	
	public void pop() {
		if (intStack.isEmpty()){
			System.out.println("No elements");
			return;
		}
		intStack.remove(0);
	}
	
	public void printTwice(){
		for (Integer i : intStack) {
			System.out.println(i);
		}
		for (Integer i : intStack) {
			System.out.println(i);
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new StackIterator();
	}
	
	private final class StackIterator implements Iterator<Integer> {

		private int counter = 0;
		
		@Override
		public boolean hasNext() {
			if (counter < intStack.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			return intStack.get(counter++);
		}
		
	}
	
}
