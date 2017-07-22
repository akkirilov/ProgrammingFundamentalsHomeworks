package service;

import javax.persistence.Query;

import model.BasicShampoo;

public class BasicShampooDao<E, K> extends DaoImpl<E, K> {

	public BasicShampooDao() {
		super();
	}

	public BasicShampoo getBasicShampooByBrand(String brand) {
		
		Query query = em.createQuery("SELECT b FROM BasicShampoo AS b WHERE b.brand = '" + brand + "'");
		BasicShampoo basicShampooDao = (BasicShampoo) query.getSingleResult();
		return basicShampooDao;
		
	}
	
}
