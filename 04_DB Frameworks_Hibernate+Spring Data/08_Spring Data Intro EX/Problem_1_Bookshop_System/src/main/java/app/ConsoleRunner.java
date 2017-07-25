package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.model.Author;
import app.model.Book;
import app.model.Category;
import app.repositories.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author = new Author();
		author.setFirstName("Gosho");
		author.setLastName("Goshevsky");
		
		Category category1 = new Category();
		category1.setName("Action");
		
		Category category2 = new Category();
		category2.setName("Comedy");
		
		Set<Category> categories = new HashSet<>();
		categories.add(category1);
		categories.add(category2);
		
		Book book = new Book();
		book.setAgeRestriction(12);
		book.setAuthor(author);
		book.setCategories(categories);
		book.setCopies(50000);
		book.setEdition(2);
		book.setPrice(15.00);
		book.setDescription("dyra-byra");
		
		bookRepository.save(book);
		
	}
    
}
