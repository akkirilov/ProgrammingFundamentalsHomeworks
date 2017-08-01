package app.services.api;

import java.util.List;

import app.models.Author;

public interface AuthorService{
	
	void save(Author author);
	
	void save(List<Author> authors);

	List<Author> findByReleaseDateOfBookBeforeYear(int year1);

	List<Author> findAllAndOrderByBooksCount();

	List<Author> findAllByFirstNameEndsWith(String suffix);

	List<Author> findAll();

	Integer getTotalCopiesOfBooks(Long id);

	Integer getTotalBooks(String firstName, String lastName);
	
}
