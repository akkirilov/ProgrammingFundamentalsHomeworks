package app.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.enums.AgeRestriction;
import app.models.Book;
import app.models.Category;
import app.models.ReducedBook;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);
	
	@Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) > :param")
	List<Book> findByReleaseDateAfterYear(@Param("param") int year);
	
	@Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) < :param")
	List<Book> findByReleaseDateBeforeYear(@Param("param") int year);
	
	List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

	@Query("SELECT b FROM Book AS b WHERE b.edition = 'GOLD' AND b.copies < 5000")
	List<Book> findAllGoldenBooksWithLessThan5000Copies();
	
	@Query("SELECT b FROM Book AS b WHERE b.price NOT BETWEEN 5 AND 40")
	List<Book> findAllByPriceNotInRange();
	
	@Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) != :year")
	List<Book> findBooksNorReleasedOnGivenYear(@Param("year") Integer year);
	
	List<Book> findAllByCategoriesIn(List<Category> categories);
	
	List<Book> findAllByReleaseDateBefore(Date date);
	
	List<Book> findAllByTitleContainingIgnoreCase(String keyWord);
	
	List<Book> findAllByAuthorLastNameStartingWithIgnoreCase(String prefix);
	
	@Query("SELECT b FROM Book AS b WHERE LENGTH(b.title) > :length")
	List<Book> findAllByMinLengthOfTitle(@Param("length") Integer length);
	
	@Query("SELECT SUM(b.price * b.copies) FROM Book AS b JOIN b.categories AS c WHERE :id IN (c.id)")
	BigDecimal findTotalProfitByCategory(@Param("id") Long id);

	@Query("SELECT b FROM Book AS b JOIN b.categories AS c WHERE :category IN (c) ORDER BY b.releaseDate DESC, b.title ASC")
	List<Book> findByCategoryOrderDateDesc(@Param("category") Category category);
	
	List<ReducedBook> findAllByTitle(@Param("title") String title);
	
	@Modifying
	@Query("UPDATE Book AS b SET b.copies = b.copies + :number WHERE b.releaseDate > :date")
	Integer increaseBooksAfterGivenDateWithGivenNumber(@Param("date") Date date, @Param("number") Integer number);
	
	@Modifying
	@Query("DELETE FROM Book WHERE copies < :number")
	Integer deleteBooksWithLowerCopiesThanGivenNumber(@Param("number") Integer number);
	
	@Modifying
	@Query(value = "DELETE FROM related_books WHERE related_book_id IN :ids", nativeQuery = true)
	void deleteRelatedBooksWithLowerCopiesThanGivenNumber(@Param("ids") List<Long> ids);
}
