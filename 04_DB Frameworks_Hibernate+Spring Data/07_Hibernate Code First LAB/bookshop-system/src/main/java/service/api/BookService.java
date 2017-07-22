package service.api;

import java.util.List;

import domain.Book;

public interface BookService<E, K> extends Service<E, K> {
	
	Book findBookByTitle(String title);
	
	Book bestSellerOfAllTimes();
	
	List<Book> mostExpensiveBooks(Integer count);
	
}
