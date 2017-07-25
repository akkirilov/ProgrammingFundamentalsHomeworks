package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	@Query("SELECT DISTINCT a FROM Author a LEFT JOIN a.books b WHERE YEAR(b.releaseDate) < :param")
	List<Author> findByReleaseDateOfBookBeforeYear(@Param("param") int year);
	
	@Query("SELECT DISTINCT a FROM Author a ORDER BY a.books.size DESC")
	List<Author> findAllAndOrderByBooksCount();
	
}
