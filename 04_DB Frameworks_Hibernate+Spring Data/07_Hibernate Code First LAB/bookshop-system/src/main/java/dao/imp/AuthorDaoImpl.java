package dao.imp;

import domain.Author;

public class AuthorDaoImpl<E, K> extends AbstractJpaDao<E, K> {
	
	public final Author findAuthorByFirstName(String firstName) {
		Author author = (Author) em.createQuery("SELECT a FROM Author AS a WHERE a.firstName = '" + firstName + "'").getSingleResult();
		return author;
	}
	
	public Author findAuthorByLastName(String LastName) {
		Author author = (Author) em.createQuery("SELECT a FROM Author AS a WHERE a.LastName = '" + LastName + "'").getSingleResult();
		return author;
	}
	
}
