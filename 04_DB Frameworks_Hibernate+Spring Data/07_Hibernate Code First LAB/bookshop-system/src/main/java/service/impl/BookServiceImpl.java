package service.impl;

import java.util.List;
import java.util.stream.Collectors;

import domain.Book;
import service.api.BookService;
import transaction.Command;
import transaction.MultiCommand;


public class BookServiceImpl extends AbstractService implements BookService{


	@Override
	public Book findBookByTitle(String title) {
		
		return (Book) runInTransaction(new Command<Book>() {
			@Override
			public Book execute() {
				List<Book> books = dao.findAll(Book.class);
				Book book = books
						.stream()
						.filter(b -> b.getTitle().equals(title))
						.findFirst().orElse(null);
				return book;
			}
		} );
	}


	@Override
	public Book bestSellerOfAllTimes() {
		return (Book) runInTransaction(new Command<Book>() {
			@Override
			public Book execute() {
				List<Book> books = dao.findAll(Book.class);
				Book book = books
						.stream()
						.sorted((a, b) -> b.getCopies().compareTo(a.getCopies()))
						.limit(1)
						.findFirst().orElse(null);
				return book;
			}
		} );
	}


	@Override
	public List<Book> mostExpensiveBooks(Integer count) {
		return (List<Book>) runInTransaction(new MultiCommand<Book>() {
			@Override
			public List<Book> execute() {
				List<Book> books = dao.findAll(Book.class);
				List<Book> booksResult = books
						.stream()
						.sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
						.limit(count)
						.collect(Collectors.toList());
				return booksResult;
			}
		} );
	}
}
