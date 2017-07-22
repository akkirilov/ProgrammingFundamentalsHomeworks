package service;

import java.util.List;

public interface Dao<E, K> {
	
	E findById(Class<E> entityClass, K id);
	
	List<E> findAll(Class<E> entityClass);	
	
}
