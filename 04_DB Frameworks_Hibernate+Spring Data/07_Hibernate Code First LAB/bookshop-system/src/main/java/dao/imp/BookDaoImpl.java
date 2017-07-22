package dao.imp;

import java.util.List;

import domain.Author;
import domain.Book;
import domain.Category;

public final class BookDaoImpl<E, K> extends AbstractJpaDao<E, K> {

	public Book getBookByTitle(String title) {
		Book book = (Book) em.createQuery("SELECT b From Book AS b WHERE b.title = '" + title + "'").getSingleResult();
		return book;
	}
	
	public Book getBookByAuthor(Author author) {
		Book book = (Book) em.createQuery("SELECT b From Book AS b WHERE b.author.id = " + author.getId()).getSingleResult();
		return book;
	}
	
	public List<Book> getBooksByCategory(Category category) {
		List<Book> books = (List<Book>) em.createQuery("SELECT b From Book AS b WHERE " +  category.getId() + " IN (SELECT c.id FROM b.categories AS c)").getResultList();
		return books;
	}
	
}
