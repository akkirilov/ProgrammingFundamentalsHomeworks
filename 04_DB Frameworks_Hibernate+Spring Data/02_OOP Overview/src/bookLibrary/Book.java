package bookLibrary;

public class Book {
	
	private String title; 
	private String author;
	private String publisher;
	private String date;
	private String ISBN;
	private double price;
	
	public Book(String title, String author, String publisher, String dateInString, String ISBN, double price) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.ISBN = ISBN;
		this.price = price;
		this.date = dateInString;
	}

	public String getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	
}
