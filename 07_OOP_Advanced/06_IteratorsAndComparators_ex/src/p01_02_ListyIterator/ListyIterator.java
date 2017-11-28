package p01_02_ListyIterator;

import java.util.Iterator;

public class ListyIterator implements Iterable<String>{

	private int index = 0;
	private String[] list;

	public ListyIterator(String... strs) {
		this.list = strs;
	}
	
	public boolean hasNext() {
		if (index + 1 < list.length) {
			return true;
		}
		return false;
	}
	
	public boolean move() {
		if (hasNext()) {
			index++;
			return true;
		}
		return false;
	}
	
	public void print() {
		if (list.length == 0) {
			System.out.println("Invalid Operation!");
			return;
		}
		System.out.println(list[index]);
	}
	
	public void printAll() {
		if (list.length == 0) {
			System.out.println("Invalid Operation!");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str + " ");
		}
		System.out.println(sb.toString());
	}

	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}
	
	private final class MyIterator implements Iterator<String> {
		
		private int counter = 0;

		@Override
		public boolean hasNext() {
			if (counter < list.length) {
				return true;
			}
			return false;
		}

		@Override
		public String next() {
			return list[counter++];
		}
		
	}
	
}
