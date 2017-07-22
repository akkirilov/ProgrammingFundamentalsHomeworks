package dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.api.Dao;

public abstract class AbstractJpaDao<E, K> implements Dao<E, K> {
	
	protected final EntityManager em;

	public AbstractJpaDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookshop");
		this.em = emf.createEntityManager();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void beginTransaction() {
		em.getTransaction().begin();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void save(E entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void delete(E entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	public E findById(Class<E> entityClass, K id) {
		E entity = (E) em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " AS e WHERE id = " + id).getSingleResult();
		return entity;
	}

	public List<E> findAll(Class<E> entityClass) {
		List<E> entities = (List<E>) em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " AS e").getResultList();
		return entities;
	}
		
}
