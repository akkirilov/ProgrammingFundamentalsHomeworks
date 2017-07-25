package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);
	
	@Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) > :param")
	List<Book> findByReleaseDateAfterYear(@Param("param") int year);
	
	@Query("SELECT b FROM Book b WHERE YEAR(b.releaseDate) < :param")
	List<Book> findByReleaseDateBeforeYear(@Param("param") int year);
	
	@Query("SELECT DISTINCT b FROM Book b JOIN b.author a ON a.firstName = 'George' AND a.lastName = 'Powell' ORDER BY b.releaseDate DESC, b.title ASC")
	List<Book> findAllFromGP();

}
