package service.api;

import domain.Author;

public interface AuthorService<E, K> extends Service<E, K>{
	
	Author findAuthorByFirstName(String firstName);
	
	Author findAuthorByLastName(String lastName);
	
}
