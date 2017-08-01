package app.services.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import app.enums.AgeRestriction;
import app.models.Book;
import app.models.Category;
import app.models.ReducedBook;

public interface BookService {
	
	void save(Book book);
	
	void save(List<Book> books);

	List<Book> findByReleaseDateAfterYear(int year);

	List<Book> findAll();

	boolean isExist(long id);

	List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

	List<Book> findAllGoldenBooksWithLessThan5000Copies();

	List<Book> findAllByPriceNotInRange();

	List<Book> findBooksNorReleasedOnGivenYear(Integer year);

	List<Book> findAllByCategoriesIn(List<Category> categories);

	List<Book> findAllByReleaseDateBefore(Date date);

	List<Book> findAllByTitleContainingIgnoreCase(String keyWord);

	List<Book> findAllByAuthorLastNameStartingWithIgnoreCase(String prefix);

	List<Book> findAllByMinLengthOfTitle(Integer length);

	BigDecimal findTotalProfitByCategory(Long id);

	List<Book> findByCategoryOrderDateDesc(Category category);

	List<ReducedBook> findAllByTitle(String title);

	Integer increaseBooksAfterGivenDateWithGivenNumber(Date date, Integer number);

	Integer deleteBooksWithLowerCopiesThanGivenNumber(Integer number);

	void deleteRelatedBooksWithLowerCopiesThanGivenNumber(List<Long> ids);

}
