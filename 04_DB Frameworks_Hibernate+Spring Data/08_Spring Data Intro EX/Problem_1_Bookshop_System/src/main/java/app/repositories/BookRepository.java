package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);

}
