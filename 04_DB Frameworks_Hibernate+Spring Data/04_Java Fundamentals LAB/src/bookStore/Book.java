package bookStore;

public class Book {
	
	private String author;
	private String bookName;
	private Double price;
	
	public Book(String bookName, Double price, String author) {
		this.author = author;
		this.bookName = bookName;
		this.price = price;
	}

	public String getAuthor() {
		return this.author;
	}

	public Double getPrice() {
		return this.price;
	}

	public String getBookName() {
		return bookName;
	}
	
}
