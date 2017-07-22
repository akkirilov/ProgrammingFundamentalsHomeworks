package service.impl;

import java.util.List;

import dao.api.Dao;
import dao.imp.AuthorDaoImpl;
import dao.imp.BookDaoImpl;
import dao.imp.CategoryDaoImpl;
import service.api.AuthorService;
import service.api.BookService;
import service.api.CategoryService;
import service.api.Service;
import transaction.Command;
import transaction.MultiCommand;

public abstract class AbstractService<E, K> implements Service<E, K> {
	protected Dao dao;
	
	protected AbstractService () {
		if(this instanceof BookService) {
			dao = new BookDaoImpl();
		} else if (this instanceof AuthorService) {
			dao = new AuthorDaoImpl();
		} else if (this instanceof CategoryService) {
			dao = new CategoryDaoImpl();
		}
	}

	public E runInTransaction(Command<E> command) {
		try {
			dao.beginTransaction();
			E result = command.execute();
			dao.commit();
			return result;
		} catch (Exception e) {
			dao.rollback();
		}
		
		return null;
	}

	public List<E> runInTransaction(MultiCommand<E> command) {
		try {
			dao.beginTransaction();
			List<E> result = command.execute();
			dao.commit();
			return result;
		} catch (Exception e) {
			dao.rollback();
		}
		
		return null;
	}
	
	public E findById(Class<E> entityClass, K id) {
		return runInTransaction(new Command<E>() {
			public E execute(){
				return (E) dao.findById(entityClass, id);
			}
		});
	}


	public void save(E entity) {
		dao.save(entity);
	}

	public void delete(E entity) {
		dao.delete(entity);
	}

	public List<E> findAll(Class<E> entityClass) {
		return runInTransaction(new MultiCommand<E>() {
			public List<E> execute(){
				return (List<E>) dao.findAll(entityClass);
			}
		});
	}
	
}
