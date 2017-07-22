package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class DaoImpl<E, K> implements Dao<E, K> {
	
	private EntityManagerFactory emf;
	protected EntityManager em;
	
	public DaoImpl() {
		emf = Persistence.createEntityManagerFactory("shampoo");
		this.em = emf.createEntityManager();
	}

	public E findById(Class<E> entityClass, K id) {
		Query query = em.createQuery("SELECT e FROM "+ entityClass.getSimpleName() + " AS e WHERE e.id = " + id);
		E entity = (E) query.getSingleResult();
		return entity;
	}

	public List<E> findAll(Class<E> entityClass) {
		Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " AS e");
		List<E> entityList = query.getResultList();
		return entityList;
	}
	
	public void beginTransaction() {
		em.getTransaction().begin();
	}
	
	public void save(E entity) {
		em.persist(entity);
	}
	
	public void commit() {
		em.getTransaction().commit();
	}
	
	public void closeDao() {
		em.close();
		emf.close();
	}

}
