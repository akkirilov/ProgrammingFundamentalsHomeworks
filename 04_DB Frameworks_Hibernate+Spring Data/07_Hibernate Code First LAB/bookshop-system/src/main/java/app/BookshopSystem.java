package app;

import java.util.HashSet;
import java.util.Set;

import domain.Author;
import domain.Book;
import domain.Category;
import service.api.BookService;
import service.impl.BookServiceImpl;

public class BookshopSystem {

	private static BookService<Book, Long> bookService = new BookServiceImpl();
	
	public static void main(String[] args) {
		
		Author author1 = new Author("Goshich", "Peshovich");
		Author author2 = new Author("Peshich", "Goshovich");
		
		Category category1 = new Category("Tikvober");
		Category category2 = new Category("Dinober");
		Category category3 = new Category("Grozdober");
		
		Set<Category> categories1 = new HashSet<>();
		categories1.add(category1);
		categories1.add(category2);
		
		Set<Category> categories2 = new HashSet<>();
		categories2.add(category2);
		categories2.add(category3);
		
		Book book1 = new Book();
		book1.setAuthor(author1);
		book1.setCategories(categories1);
		book1.setCopies(5);
		book1.setTitle("Beracha");
		
		Book book2 = new Book();
		book2.setAuthor(author2);
		book2.setCategories(categories2);
		book2.setCopies(5);
		book2.addRelatedBook(book1);
		book2.setTitle("Melacha");
		
		bookService.save(book1);
		bookService.save(book2);		
		
	}

}
