package app.services.api;

import java.util.List;

import app.models.Book;

public interface BookService{
	
	void save(Book book);
	
	void save(List<Book> books);

	List<Book> findByReleaseDateAfterYear(int year);

	List<Book> findAll();

	boolean isExist(long id);
	
}
