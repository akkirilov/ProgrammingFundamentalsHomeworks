package p06_StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		
		int res = Integer.compare(p1.getName().length(), p2.getName().length());
		
		if (res == 0) {
			res = Character.compare(p1.getName().toLowerCase().charAt(0), p2.getName().toLowerCase().charAt(0));
		}
		
		return res;
	}

}
