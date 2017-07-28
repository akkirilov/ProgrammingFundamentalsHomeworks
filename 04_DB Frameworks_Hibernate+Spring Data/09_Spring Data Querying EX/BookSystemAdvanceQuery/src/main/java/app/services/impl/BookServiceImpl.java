package app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.models.Book;
import app.repositories.BookRepository;
import app.services.api.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void save(List<Book> books) {
		bookRepository.save(books);
	}

	@Override
	public List<Book> findByReleaseDateAfterYear(int year) {
		return bookRepository.findByReleaseDateAfterYear(year);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public boolean isExist(long id) {
		Book test = null;
		test = bookRepository.findOne(id);
		if (test == null) {
			return false;
		} else {
			return true;
		}
	}

}
