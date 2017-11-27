package p01_04_Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

	private String title;
	private int year;
	private List<String> authors;
	
	public Book(String title, int year, String... authors) {
		super();
		setTitle(title);
		setYear(year);
		setAuthors(authors);
	}

	private void setTitle(String title){
		this.title = title;
	}
	
	private void setYear(int year){
		this.year = year;
	}
	
	private void setAuthors(String... authors){
		if (authors.length == 0) {
			this.authors = new ArrayList<>();
		} else {
			this.authors = new ArrayList<>(Arrays.asList(authors));
		}
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public List<String> getAuthors(){
		return this.authors;
	}

	@Override
	public int compareTo(Book book) {
		return book.getTitle().compareTo(this.getTitle());
	}

	@Override
	public String toString() {
		return this.title;
	}
	
}
