package p01_04_Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		int res = book2.compareTo(book1);
		if (res == 0) {
			res = Integer.compare(book2.getYear(), book1.getYear());
		}
		return res;
	}

}
