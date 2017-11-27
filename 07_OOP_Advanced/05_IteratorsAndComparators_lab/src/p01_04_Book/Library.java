package p01_04_Book;

import java.util.Iterator;

@SuppressWarnings("hiding")
public class Library<Book> implements Iterable<Book>{

	private Book[] books;

	@SuppressWarnings("unchecked")
	public Library(Book... books) {
		this.setBooks(books);
	}

	private void setBooks(Book[] books) {
		this.books = books;
	}

	public Book[] getBooks() {
		return this.books;
	}

	@Override
	public Iterator<Book> iterator() {
		return new LibraryIterator();
	}
	
	private final class LibraryIterator implements Iterator<Book> {

		private int counter = 0;
		
		@Override
		public boolean hasNext() {
			if (counter < books.length) {
				return true;
			}
			return false;
		}

		@Override
		public Book next() {
			return books[counter++];
		}
		
	}
	
}
