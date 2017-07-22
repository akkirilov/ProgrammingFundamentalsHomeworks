package service.impl;

import java.util.List;

import domain.Author;
import service.api.AuthorService;
import transaction.Command;

public class AuthorServiceImpl<E> extends AbstractService implements AuthorService {

	
	@Override
	public Author findAuthorByFirstName(String firstName) {
		return (Author) runInTransaction(new Command<Author>() {
			public Author execute(){
				List<Author> authors = dao.findAll(Author.class);
				Author author = authors
						.stream()
						.filter(a -> a.getFirstName().equals(firstName))
						.findFirst()
						.orElse(null);
				return author;
			}
		});
	}

	
	@Override
	public Author findAuthorByLastName(String lastName) {
		return (Author) runInTransaction(new Command<Author>() {
			public Author execute(){
				List<Author> authors = dao.findAll(Author.class);
				Author author = authors
						.stream()
						.filter(a -> a.getFirstName().equals(lastName))
						.findFirst()
						.orElse(null);
				return author;
			}
		});
	}


	@Override
	public void save(Object entity) {
		super.save(entity);
	}	
	
	

}
