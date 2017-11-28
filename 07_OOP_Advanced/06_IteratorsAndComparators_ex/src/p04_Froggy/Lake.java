package p04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
	
	private List<Integer> lake;

	public Lake(Integer... nums) {
		this.setLake(nums);
	}

	private void setLake(Integer... nums) {
		this.lake = new ArrayList<>(Arrays.asList(nums));
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Frog();
	}
	
	private final class Frog implements Iterator<Integer> {

		private int counter = 0;
		boolean isOdd = false;
		
		@Override
		public boolean hasNext() {
			if (counter < lake.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			int index = counter;
			counter+=2;
			if (!isOdd && counter > lake.size() - 1) {
				counter = 1;
				isOdd = true;
			}
			return lake.get(index);
		}
		
	}

}	
