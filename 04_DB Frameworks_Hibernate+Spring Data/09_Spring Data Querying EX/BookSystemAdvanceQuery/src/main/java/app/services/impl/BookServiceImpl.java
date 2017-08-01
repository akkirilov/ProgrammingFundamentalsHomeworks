package app.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.enums.AgeRestriction;
import app.models.Book;
import app.models.Category;
import app.models.ReducedBook;
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

	@Override
	public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
		return bookRepository.findAllByAgeRestriction(ageRestriction);
	}

	@Override
	public List<Book> findAllGoldenBooksWithLessThan5000Copies() {
		return bookRepository.findAllGoldenBooksWithLessThan5000Copies();
	}

	@Override
	public List<Book> findAllByPriceNotInRange() {
		return bookRepository.findAllByPriceNotInRange();
	}

	@Override
	public List<Book> findBooksNorReleasedOnGivenYear(Integer year) {
		return bookRepository.findBooksNorReleasedOnGivenYear(year);
	}

	@Override
	public List<Book> findAllByCategoriesIn(List<Category> categories) {
		return bookRepository.findAllByCategoriesIn(categories);
	}

	@Override
	public List<Book> findAllByReleaseDateBefore(Date date) {
		return bookRepository.findAllByReleaseDateBefore(date);
	}

	@Override
	public List<Book> findAllByTitleContainingIgnoreCase(String keyWord) {
		return bookRepository.findAllByTitleContainingIgnoreCase(keyWord);
	}

	@Override
	public List<Book> findAllByAuthorLastNameStartingWithIgnoreCase(String prefix) {
		return bookRepository.findAllByAuthorLastNameStartingWithIgnoreCase(prefix);
	}

	@Override
	public List<Book> findAllByMinLengthOfTitle(Integer length) {
		return bookRepository.findAllByMinLengthOfTitle(length);
	}

	@Override
	public BigDecimal findTotalProfitByCategory(Long id) {
		return bookRepository.findTotalProfitByCategory(id);
	}

	@Override
	public List<Book> findByCategoryOrderDateDesc(Category category) {
		return bookRepository.findByCategoryOrderDateDesc(category);
	}
	
	public List<ReducedBook> findAllByTitle(String title) {
		return bookRepository.findAllByTitle(title);
	}

	@Override
	public Integer increaseBooksAfterGivenDateWithGivenNumber(Date date, Integer number) {
		return bookRepository.increaseBooksAfterGivenDateWithGivenNumber(date, number);
	}

	@Override
	public Integer deleteBooksWithLowerCopiesThanGivenNumber(Integer number) {
		return bookRepository.deleteBooksWithLowerCopiesThanGivenNumber(number);
	}

	@Override
	public void deleteRelatedBooksWithLowerCopiesThanGivenNumber(List<Long> ids) {
		bookRepository.deleteRelatedBooksWithLowerCopiesThanGivenNumber(ids);
	}
	
}
